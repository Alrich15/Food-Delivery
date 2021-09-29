package com.sprint.exception;

public class RestaurantCategoryNotFoundException extends RuntimeException {
	
	public RestaurantCategoryNotFoundException() {
		super();
	}
	
	public RestaurantCategoryNotFoundException(String msg) {
		super(msg);
	}
	
	public RestaurantCategoryNotFoundException(Throwable cause) {
		super(cause);
	}

}
