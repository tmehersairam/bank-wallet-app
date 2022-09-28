package com.fis.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ExceptionResponse> customerException(CustomerException customerException,
			WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setException(customerException.getMessage());
		exceptionResponse.setPath(request.getDescription(false));
		exceptionResponse.setTimeStamp(new Date().toString());
		exceptionResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
