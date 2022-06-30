package com.triple.traveler.place.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triple.traveler.common.dao.CommonDao;
import com.triple.traveler.place.dto.res.PlaceRes;

@Service
public class PlaceService {
	
	@Autowired
	private CommonDao commonDao;
	
	@SuppressWarnings("unchecked")
	public List<PlaceRes> getPlaces() {
		return (List<PlaceRes>) commonDao.selectList("Place.getPlaceList" , null);
	}
}
