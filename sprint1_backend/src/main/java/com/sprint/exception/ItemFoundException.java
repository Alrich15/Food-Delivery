package com.sprint.exception;

public class ItemFoundException extends RuntimeException{

	public ItemFoundException() {
		super();
	}
	
	public ItemFoundException(String message) {
		super(message);
	}
	
	public ItemFoundException(Throwable cause) {
		super(cause);
	}
}
