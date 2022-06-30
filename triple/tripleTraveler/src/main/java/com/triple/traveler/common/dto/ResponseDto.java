package com.triple.traveler.common.dto;
import org.springframework.http.HttpStatus;

public class ResponseDto<T> {

	//결과 리턴 객체
	private T data;
	//서버 메시지
	private String message;
	//코드
	private HttpStatus httpStatus;
	
	public ResponseDto(T data , String message ,HttpStatus httpStatus) {
		this.data = data;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}


	
	
}
