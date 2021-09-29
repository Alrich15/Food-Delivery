package com.sprint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sprint.entity.FoodCartErrorResponse;

@ControllerAdvice
public class FoodCartExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<FoodCartErrorResponse> handleException(FoodCartNotFoundException exception){
		FoodCartErrorResponse error=new FoodCartErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); ////404 Not found
	}
	
	@ExceptionHandler
	public ResponseEntity<FoodCartErrorResponse> handleException(FoodCartAlreadyExistsException exception){
		FoodCartErrorResponse error=new FoodCartErrorResponse();
		
		error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY); ///409 Conflict
	}
	

}
