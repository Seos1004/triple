package com.triple.traveler.event.controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triple.traveler.common.dto.ResponseDto;
import com.triple.traveler.event.dto.req.EventsReqDto;
import com.triple.traveler.event.service.EventService;

/**
*
* @programName : EventController
* @author : save7412
* @description : 이벤트 컨트롤러
*/

@RestController
@RequestMapping("/api")
public class EventController {
	@Autowired
	private EventService es;
	
	@PostMapping("/events")
	public ResponseEntity<ResponseDto<Object>> reviewEvent(@RequestBody EventsReqDto eventsReqDto) throws Exception {
		return ResponseEntity.status(200).body(new ResponseDto<>(es.reviewEvent(eventsReqDto), "통신 성공" , HttpStatus.OK));
	}
	
	@GetMapping("/uuid")
	public ResponseEntity<ResponseDto<Object>> getUuid() throws Exception {
		ArrayList<String> uuids = new ArrayList<String>();
		for(int i = 0; i < 10; i++) {
			uuids.add(UUID.randomUUID().toString());
		}
		return ResponseEntity.status(200).body(new ResponseDto<>(uuids, "통신 성공" , HttpStatus.OK));
	}
	
}



