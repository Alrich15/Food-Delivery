package com.sprint.exception;

public class ItemCategoryAlreadyExistsException extends RuntimeException {
	
	public ItemCategoryAlreadyExistsException() {
		super();
	}
	
	public ItemCategoryAlreadyExistsException(String msg) {
		super(msg);
	}
	
	public ItemCategoryAlreadyExistsException(Throwable cause) {
		super(cause);
	}

}
