package com.sprint.exception;

public class ItemCategoryNotFoundException extends RuntimeException {

	public ItemCategoryNotFoundException() {
		super();
	}
	
	public ItemCategoryNotFoundException(String msg) {
		super(msg);
	}
	
	public ItemCategoryNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
