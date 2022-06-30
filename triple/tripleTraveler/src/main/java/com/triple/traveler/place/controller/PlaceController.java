package com.triple.traveler.place.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triple.traveler.common.dto.ResponseDto;
import com.triple.traveler.place.service.PlaceService;

/**
*
* @programName : PlaceController
* @author : save7412
* @description : 이벤트 컨트롤러
*/

@RestController
@RequestMapping("/api")
public class PlaceController {
	@Autowired
	private PlaceService ps;
	
	@GetMapping("/places")
	public ResponseEntity<ResponseDto<Object>> reviewEvent() throws Exception {
		return ResponseEntity.status(200).body(new ResponseDto<>(ps.getPlaces(), "통신 성공" , HttpStatus.OK));
	}
	
	
}



