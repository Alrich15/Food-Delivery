package com.sprint.exception;

//Exception class if given bill is not found
public class BillNotFoundException extends RuntimeException{

	public BillNotFoundException() {
		super();
	}

	public BillNotFoundException(String message) {
		super(message);
	}

	public BillNotFoundException(Throwable cause) {
		super(cause);
	}

}
