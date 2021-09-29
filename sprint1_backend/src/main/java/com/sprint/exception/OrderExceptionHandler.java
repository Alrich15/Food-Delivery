package com.sprint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sprint.entity.OrderDetailsErrorResponse;

/*
 * Handles the exception globally
 */
@ControllerAdvice
public class OrderExceptionHandler {
	
	@ExceptionHandler //provides a mechanism to treat exceptions that are thrown during service method implementation
	/*
	 * This method returns a ResponseEntity for writing to the response with a message.
	 */
	public ResponseEntity<OrderDetailsErrorResponse> handleException(OrderAlreadyExistException exception){
		OrderDetailsErrorResponse error = new OrderDetailsErrorResponse();
		
		error.setStatus(HttpStatus.CONFLICT.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);  //409 Already Exist
		
	}
	
	@ExceptionHandler //provides a mechanism to treat exceptions that are thrown during service method implementation
	/*
	 * This method returns a ResponseEntity for writing to the response with a message.
	 */
	public ResponseEntity<OrderDetailsErrorResponse> handleException(OrderNotFoundException exception){
		OrderDetailsErrorResponse error = new OrderDetailsErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not Found
		
	}

}
