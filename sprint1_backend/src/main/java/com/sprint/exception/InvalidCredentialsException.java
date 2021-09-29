package com.sprint.exception;

public class InvalidCredentialsException extends Exception{

	public InvalidCredentialsException() {
		super();
	}

	public InvalidCredentialsException(String message) {
		super(message);
	}

	public InvalidCredentialsException(Throwable cause) {
		super(cause);
	}
	

}
