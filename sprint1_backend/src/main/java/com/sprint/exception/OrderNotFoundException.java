package com.sprint.exception;

public class OrderNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Default Constructor
	 */
	public OrderNotFoundException() {
		super();
		
	}

	/*
	 * Constructor Using Fields
	 */
	public OrderNotFoundException(String message) {
		super(message);
		
	}

	/*
	 * Constructor from superclass
	 */
	public OrderNotFoundException(Throwable cause) {
		super(cause);
		
	}
	

}
