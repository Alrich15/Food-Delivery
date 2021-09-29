package com.sprint.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sprint.entity.ItemCategoryErrorResponse;


@ControllerAdvice
public class ItemCategoryExceptionHandler {
	@ExceptionHandler(ItemCategoryAlreadyExistsException.class)
	public ResponseEntity<ItemCategoryErrorResponse> itemCategoryAlreadyExistsException(ItemCategoryAlreadyExistsException exception){
		ItemCategoryErrorResponse error = new ItemCategoryErrorResponse();
		 error.setStatus(HttpStatus.CONFLICT.value());
		 error.setMessage(exception.getMessage());
		 error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ItemCategoryNotFoundException.class)
	public ResponseEntity<ItemCategoryErrorResponse> itemCategoryNotFoundException(ItemCategoryNotFoundException exception){
		ItemCategoryErrorResponse error = new ItemCategoryErrorResponse();
		 error.setStatus(HttpStatus.NOT_FOUND.value());
		 error.setMessage(exception.getMessage());
		 error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
}
