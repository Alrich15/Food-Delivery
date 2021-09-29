package com.sprint.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sprint.entity.RestaurantErrorResponse;
/*
 * @ControllerAdvice- handles exception across whole application in one global handling component.
 * @ExceptionHandler- handles the exception  raised during execution of the controller methods
 */

/*
 *  Exceptions are handled for 404 and 409
 */

@ControllerAdvice
public class RestaurantExceptionHandler {

	// Exception handling for restaurant not found
	@ExceptionHandler
	public ResponseEntity<RestaurantErrorResponse> handleException(RestaurantNotFoundException exception) {
		RestaurantErrorResponse error = new RestaurantErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // 404 Not found
	}

	// Exception handling for already existing restaurants
	@ExceptionHandler(RestaurantAlreadyExistsException.class)
	public ResponseEntity<RestaurantErrorResponse> handleException(RestaurantAlreadyExistsException exception) {
		RestaurantErrorResponse error = new RestaurantErrorResponse();

		error.setStatus(HttpStatus.CONFLICT.value());

		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.CONFLICT); // 409 Conflict
	}

}
