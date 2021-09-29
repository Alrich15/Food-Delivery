package com.sprint.exception;

public class UserNotFoundException extends Exception{

	public UserNotFoundException(String message) {
		super(message);
	}
	
	public UserNotFoundException() {
		super();
	}

	

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}
	

}
