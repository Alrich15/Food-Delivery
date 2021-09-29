package com.sprint.exception;

public class FoodCartAlreadyExistsException extends RuntimeException{

	public FoodCartAlreadyExistsException() {
    	super();
    }
    
    public FoodCartAlreadyExistsException(String message) {

    	super(message);
    }
    public FoodCartAlreadyExistsException(Throwable cause) {
    	
    	super(cause);
    }

}
