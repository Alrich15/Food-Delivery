package com.sprint.exception;

public class ItemAlreadyExistsException extends RuntimeException {
	
	public ItemAlreadyExistsException() {
		super();
	}
	
	public ItemAlreadyExistsException(String message) {
		super(message);
	}
	
	public ItemAlreadyExistsException(Throwable cause) {
		super(cause);
	}

}
