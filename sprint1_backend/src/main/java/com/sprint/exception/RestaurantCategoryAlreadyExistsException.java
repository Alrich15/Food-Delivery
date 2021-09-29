package com.sprint.exception;

public class RestaurantCategoryAlreadyExistsException extends RuntimeException{
	
	public RestaurantCategoryAlreadyExistsException() {
		super();
	}
	
	public RestaurantCategoryAlreadyExistsException(String msg) {
		super(msg);
	}
	
	public RestaurantCategoryAlreadyExistsException(Throwable cause) {
		super(cause);
	}

}
