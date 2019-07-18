package com.everis.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class CustomizeExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomizeErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exc, WebRequest req) {
		
		CustomizeErrorDetails resourceNotFound = new CustomizeErrorDetails(new Date(), exc.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeErrorDetails>(resourceNotFound, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(DataException.class)
	public ResponseEntity<CustomizeErrorDetails> handlDataFormatException(DataException exc, WebRequest req){
		
		CustomizeErrorDetails dataErrorDetail = new CustomizeErrorDetails(new Date(), exc.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeErrorDetails> (dataErrorDetail, HttpStatus.BAD_REQUEST);
	}
}
