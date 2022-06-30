package com.triple.traveler.review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triple.traveler.common.dao.CommonDao;
import com.triple.traveler.point.vo.PointM;
import com.triple.traveler.review.vo.Review;

@Service
public class ReviewService {
	
	@Autowired
	private CommonDao commonDao;
	
	public int createReview(Review reviewVo) {
		return commonDao.insert("Review.createReview" , reviewVo);
	}
	public int modifyReview(Review reviewVo) {
		return commonDao.update("Review.modifyReview" , reviewVo);
	}
	public int removeReview(Review reviewVo) {
		return commonDao.update("Review.removeReview" , reviewVo);
	}
	
	public int reviewBonusChk(String placeId) {
		return (int) commonDao.selectOne("Review.reviewBonusChk" , placeId);
	}
	
	public Review getReviewDetail(String reviewId) throws Exception {
		return (Review) commonDao.selectOne("Review.getReviewDetail" , reviewId);
	}
}
