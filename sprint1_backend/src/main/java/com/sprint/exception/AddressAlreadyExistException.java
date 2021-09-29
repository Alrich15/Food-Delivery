package com.sprint.exception;

public class AddressAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AddressAlreadyExistException() {
		super();
		
	}

	public AddressAlreadyExistException(String message) {
		super(message);
		
	}

	public AddressAlreadyExistException(Throwable cause) {
		super(cause);
		
	}
	
}
