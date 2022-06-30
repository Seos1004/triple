package com.triple.traveler.point.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triple.traveler.common.dao.CommonDao;
import com.triple.traveler.point.dto.res.PointRes;
import com.triple.traveler.point.vo.PointD;
import com.triple.traveler.point.vo.PointM;

@Service
public class PointService {
	
	@Autowired
	private CommonDao commonDao;

	@SuppressWarnings("unchecked")
	public List<PointRes> getPoints(String userId) throws Exception {
		return (List<PointRes>) commonDao.selectList("Point.getPointList" , userId);
	}
	
	public int createPointM(PointM pointM) {
		return commonDao.insert("Point.createPointM" , pointM);
	}
	
	public int modifyPointM(PointM pointM) {
		return commonDao.update("Point.modifyPointM" , pointM);
	}
	
	public int createPointD(PointD pointD) {
		return commonDao.insert("Point.createPointD" , pointD);
	}
	
	public PointM getUserPoint(String userId) throws Exception {
		return (PointM) commonDao.selectOne("Point.getUserPoint" , userId);
	}
	
	public int getReviewPoint(PointD pointD) {
		return (int) commonDao.selectOne("Point.getReviewPoint" , pointD);
	}

}
	
