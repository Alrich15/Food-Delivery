package com.sprint.exception;


public class OrderAlreadyExistException extends RuntimeException {
	
	/**
	 * serialVersionUID is a 64 bit number used to uniquely identify a class during deSerialization process
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Default Constructor
	 */
	public OrderAlreadyExistException() {
		super();
	}
	
	/*
	 * Constructor Using Fields
	 */
	public OrderAlreadyExistException(String message) {
		super(message);
	}
	
	/*
	 * Constructor from superclass
	 */
	public OrderAlreadyExistException(Throwable cause) {
		super(cause);
	}

}
