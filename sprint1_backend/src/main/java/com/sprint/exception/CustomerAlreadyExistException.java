package com.sprint.exception;

public class CustomerAlreadyExistException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerAlreadyExistException() {
		super();
	}
	
	public CustomerAlreadyExistException(String message) {
		super(message);
	}
	
	public CustomerAlreadyExistException(Throwable cause) {
		super(cause);
	} 

}
