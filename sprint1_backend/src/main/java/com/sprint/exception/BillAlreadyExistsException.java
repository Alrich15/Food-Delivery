package com.sprint.exception;

//Exception class if already existing bill is added
public class BillAlreadyExistsException extends RuntimeException{

	public BillAlreadyExistsException() {
		super();
	}

	public BillAlreadyExistsException(String message) {
		super(message);
	}

	public BillAlreadyExistsException(Throwable cause) {
		super(cause);
	}

}