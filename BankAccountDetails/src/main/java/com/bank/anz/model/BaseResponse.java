package com.bank.anz.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class BaseResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3378879340847116703L;
	HttpStatus status;
	String message;
	String desc;
	
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
