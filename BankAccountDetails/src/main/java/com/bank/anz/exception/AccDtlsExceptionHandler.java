package com.bank.anz.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bank.anz.model.AccountDetailsResponse;
import com.bank.anz.util.AccDtlsConstants;

@ControllerAdvice
public class AccDtlsExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(AccDtlsExceptionHandler.class);
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<AccountDetailsResponse> handleException(Exception e) {
		logger.error("Exception occurred...: "+e.getMessage());
		e.printStackTrace();
		AccountDetailsResponse resp=new AccountDetailsResponse();
		resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		resp.setMessage(AccDtlsConstants.FAILURE_STRING);
		resp.setDesc("An exception occurred");
		return new ResponseEntity<AccountDetailsResponse>(resp,resp.getStatus());
		
	}

}
