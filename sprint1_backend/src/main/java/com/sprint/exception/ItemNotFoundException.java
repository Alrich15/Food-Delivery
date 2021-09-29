package com.sprint.exception;

public class ItemNotFoundException extends RuntimeException {
	
	public ItemNotFoundException() {
		super();
	}
	
	public ItemNotFoundException(String message) {
		super(message);
	}
	
	public ItemNotFoundException(Throwable cause) {
		super(cause);
	}

}
