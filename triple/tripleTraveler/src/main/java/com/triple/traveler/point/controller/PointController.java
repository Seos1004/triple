package com.triple.traveler.point.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triple.traveler.common.dto.ResponseDto;
import com.triple.traveler.point.service.PointService;

/**
*
* @programName : PointController
* @author : save7412
* @description : 포인트 컨트롤러
*/

@RestController
@RequestMapping("/api/point")
public class PointController {
	
	@Autowired
	private PointService ps;
	
	@GetMapping
	public ResponseEntity<ResponseDto<Object>> getCdList(String userId) throws Exception {
		if(userId.equals("") || userId == null) {
			throw new Exception();
		}
		return ResponseEntity.status(200).body(new ResponseDto<>(ps.getPoints(userId), "통신 성공" , HttpStatus.OK));
	}
	
}



