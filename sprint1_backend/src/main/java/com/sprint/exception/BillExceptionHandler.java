package com.sprint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sprint.entity.BillErrorResponse;

@ControllerAdvice
public class BillExceptionHandler {
	//Method for handling exception if given bill is not found
	@ExceptionHandler
	public ResponseEntity<BillErrorResponse> BillNotFoundException(BillNotFoundException exception){
		BillErrorResponse error = new BillErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//Method for handling exception if already existing bill is added
	@ExceptionHandler
	public ResponseEntity<BillErrorResponse> BillAlreadyExistsException(BillAlreadyExistsException exception){
		BillErrorResponse error = new BillErrorResponse();
		 
		error.setStatus(HttpStatus.CONFLICT.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
}

