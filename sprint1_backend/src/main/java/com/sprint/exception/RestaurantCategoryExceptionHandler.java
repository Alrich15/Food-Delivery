package com.sprint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sprint.entity.RestaurantCategoryErrorResponse;

@ControllerAdvice
public class RestaurantCategoryExceptionHandler {
	
@ExceptionHandler(RestaurantCategoryAlreadyExistsException.class)
public ResponseEntity<RestaurantCategoryErrorResponse> restCategoryAlreadyExistsException(RestaurantCategoryAlreadyExistsException exception){
	RestaurantCategoryErrorResponse error = new RestaurantCategoryErrorResponse();
	 error.setStatus(HttpStatus.CONFLICT.value());
	 error.setMessage(exception.getMessage());
	 error.setTimeStamp(System.currentTimeMillis());
	return new ResponseEntity<>(error, HttpStatus.CONFLICT);
}
	
	
@ExceptionHandler(RestaurantCategoryNotFoundException.class)
public ResponseEntity<RestaurantCategoryErrorResponse> restCategoryNotFoundException(RestaurantCategoryNotFoundException exception){
	RestaurantCategoryErrorResponse error = new RestaurantCategoryErrorResponse();
	 error.setStatus(HttpStatus.NOT_FOUND.value());
	 error.setMessage(exception.getMessage());
	 error.setTimeStamp(System.currentTimeMillis());
	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
} 

}
