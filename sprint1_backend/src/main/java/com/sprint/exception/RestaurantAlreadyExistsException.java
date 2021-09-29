package com.sprint.exception;

//define class too handle RestaurantAlreadyExistsException
public class RestaurantAlreadyExistsException extends RuntimeException {

	public RestaurantAlreadyExistsException() {
		super();

	}

	public RestaurantAlreadyExistsException(String message) {
		super(message);

	}

	public RestaurantAlreadyExistsException(Throwable cause) {
		super(cause);

	}

}