package com.sprint.exception;

public class AddressNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddressNotFoundException() {
		super();
		
	}

	public AddressNotFoundException(String message) {
		super(message);
		
	}

	public AddressNotFoundException(Throwable cause) {
		super(cause);
		
	}
}
