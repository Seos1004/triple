package com.triple.traveler.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.triple.traveler.event.EventConstant;
import com.triple.traveler.event.dto.req.EventsReqDto;
import com.triple.traveler.point.PointConstant;
import com.triple.traveler.point.service.PointService;
import com.triple.traveler.point.vo.PointD;
import com.triple.traveler.point.vo.PointM;
import com.triple.traveler.review.service.ReviewService;
import com.triple.traveler.review.vo.Review;

@Service
public class EventService {
	
	@Autowired
	private ReviewService rs;
	
	@Autowired
	private PointService ps;

	@Transactional
	public EventsReqDto reviewEvent(EventsReqDto eventsReqDto) throws Exception {
		PointM userPoint = ps.getUserPoint(eventsReqDto.getUserId());
		if(userPoint == null) {
			userPoint = firstReviewPointTblSetting(eventsReqDto.getUserId());
		}
		boolean contentPoint = false;
		boolean imgPoint = false;
		boolean firstBonusPoint = true;
		
		Review reviewVo = eventsReqDtoToReviewVo(eventsReqDto);
		PointD pointD = new PointD();
		pointD.setUserId(reviewVo.getUserId());
		pointD.setPdSystemType(PointConstant.POINT_SYSTEM_TYPE_REVIEW);
		pointD.setReviewId(reviewVo.getReviewId());
		pointD.setPmId(userPoint.getPmId());
		pointD.setPlaceId(reviewVo.getPlaceId());
		
		switch (eventsReqDto.getAction()) {
			case EventConstant.ACTION_TYPE_ADD:
				rs.createReview(reviewVo);
				if(eventsReqDto.getContent().length() > 0) {
					contentPoint = true;
				}
				if(eventsReqDto.getAttachedPhotoIds().length > 0) {
					imgPoint = true;
				}
				if(rs.reviewBonusChk(eventsReqDto.getPlaceId()) > 0) {
					firstBonusPoint = false;
				}
				if(contentPoint) {
					modifyPointSetting(PointConstant.POINT_TYPE_CONTENT_POINT , pointD , true);
				}
				if(imgPoint) {
					modifyPointSetting(PointConstant.POINT_TYPE_IMG_POINT , pointD , true);
				}
				if(firstBonusPoint) {
					modifyPointSetting(PointConstant.POINT_TYPE_FIRST_BONUS_POINT , pointD , true);
				}
				break;
			case EventConstant.ACTION_TYPE_MOD:
				Review review = rs.getReviewDetail(reviewVo.getReviewId());
				System.out.println(review.toString());
				if(review.getAttachedPhotoIds() != null && !review.getAttachedPhotoIds().equals("")) {
					String [] attachedPhotoIdArr = review.getAttachedPhotoIds().split("^"); 
					if(attachedPhotoIdArr.length <= 0 && eventsReqDto.getAttachedPhotoIds().length > 0) {
						imgPoint = true;
						modifyPointSetting(PointConstant.POINT_TYPE_REVIEW_MODIFY_IMG_POINT , pointD , imgPoint);
					}else if(attachedPhotoIdArr.length > 0 && eventsReqDto.getAttachedPhotoIds().length <= 0){
						imgPoint = false;
						modifyPointSetting(PointConstant.POINT_TYPE_REVIEW_MODIFY_IMG_POINT , pointD , imgPoint);
					}else {
						System.out.println("이미지 포인트 부여 없음");
					}
				}else if(eventsReqDto.getAttachedPhotoIds().length > 0){
					modifyPointSetting(PointConstant.POINT_TYPE_REVIEW_MODIFY_IMG_POINT , pointD , imgPoint);
				}else {
					System.out.println("이미지 포인트 부여 없음");
				}
				
				if(review.getReviewContent().length() <= 0 && eventsReqDto.getContent().length() > 0){
					contentPoint = true;
					modifyPointSetting(PointConstant.POINT_TYPE_REVIEW_MODIFY_CONTENT_POINT , pointD , contentPoint);
				}else if(review.getReviewContent().length() > 0 && eventsReqDto.getContent().length() <= 0) {
					contentPoint = false;
					modifyPointSetting(PointConstant.POINT_TYPE_REVIEW_MODIFY_CONTENT_POINT , pointD , contentPoint);
				}else {
					System.out.println("내용 포인트 부여 없음");
				}
				rs.modifyReview(reviewVo);
				break;
			case EventConstant.ACTION_TYPE_DELETE:
				int withdrawPoint = ps.getReviewPoint(pointD);
				deletePointSetting(PointConstant.POINT_TYPE_REVIEW_REMOVE_POINT , pointD , withdrawPoint) ;
				rs.removeReview(reviewVo);
				break;
			default:
				throw new Exception();
		}
		return eventsReqDto;
	}
	
	
	private Review eventsReqDtoToReviewVo(EventsReqDto eventsReqDto) {
		Review reviewVo = new Review();
		reviewVo.setUserId(eventsReqDto.getUserId());
		reviewVo.setReviewContent(eventsReqDto.getContent());
		if(eventsReqDto.getAttachedPhotoIds().length > 0) {
			String ids = "";
			for(String itme : eventsReqDto.getAttachedPhotoIds()) {
				ids += itme + "^";
			}
			ids = ids.substring(0, ids.length() - 1);
			reviewVo.setAttachedPhotoIds(ids);
		}
		reviewVo.setPlaceId(eventsReqDto.getPlaceId());
		reviewVo.setReviewId(eventsReqDto.getReviewId());
		return reviewVo;
	}

	private void modifyPointSetting(String pdPointType , PointD pointD, boolean isAddPoint) {
		PointM pointM = new PointM();
		pointD.setPdPoint(isAddPoint ? 1 : -1);
		pointD.setPdPointType(pdPointType);
		ps.createPointD(pointD);
		pointM.setPmId(pointD.getPmId());
		pointM.setPmPoint(isAddPoint ? 1 : -1);
		ps.modifyPointM(pointM);
	}
	private void deletePointSetting(String pdPointType , PointD pointD, int withdrawPoint) {
		PointM pointM = new PointM();
		pointD.setPdPoint(withdrawPoint * -1);
		pointD.setPdPointType(pdPointType);
		ps.createPointD(pointD);
		pointM.setPmId(pointD.getPmId());
		pointM.setPmPoint(withdrawPoint * -1);
		ps.modifyPointM(pointM);
	}
	
	private PointM firstReviewPointTblSetting(String userId) throws Exception {
		PointM pointM = new PointM();
		pointM.setUserId(userId);
		ps.createPointM(pointM);
		pointM = ps.getUserPoint(userId);
		return pointM;
	}
}
	
