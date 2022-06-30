package com.triple.traveler.common.dto;
import org.springframework.http.HttpStatus;

public class ResponseDto<T> {

	//��� ���� ��ü
	private T data;
	//���� �޽���
	private String message;
	//�ڵ�
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
