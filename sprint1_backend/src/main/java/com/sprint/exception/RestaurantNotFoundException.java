package com.sprint.exception;

// define class too handle RestaurantNotFoundException
public class RestaurantNotFoundException extends RuntimeException {

	public RestaurantNotFoundException() {
		super();

	}

	public RestaurantNotFoundException(String message) {
		super(message);

	}

	public RestaurantNotFoundException(Throwable cause) {
		super(cause);

	}

}
