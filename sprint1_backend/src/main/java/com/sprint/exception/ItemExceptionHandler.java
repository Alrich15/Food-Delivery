package com.sprint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sprint.entity.ItemExceptionResponse;

@ControllerAdvice
public class ItemExceptionHandler {
	@ExceptionHandler(ItemAlreadyExistsException.class)
	public ResponseEntity<ItemExceptionResponse> itemCategoryAlreadyExistsException(ItemAlreadyExistsException exception){
		ItemExceptionResponse error = new ItemExceptionResponse();
		 error.setStatus(HttpStatus.CONFLICT.value());
		 error.setMessage(exception.getMessage());
		 error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<ItemExceptionResponse> itemCategoryNotFoundException(ItemNotFoundException exception){
		ItemExceptionResponse error = new ItemExceptionResponse();
		 error.setStatus(HttpStatus.NOT_FOUND.value());
		 error.setMessage(exception.getMessage());
		 error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
}
