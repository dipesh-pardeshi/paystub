package com.hsbc.paystub.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler
	public ResponseEntity<String> handleError(Throwable t)
	{
		logger.error("Error occured : ", t);
		return new ResponseEntity<String>(t.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
