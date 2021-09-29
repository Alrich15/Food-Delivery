package com.sprint.exception;

public class FoodCartNotFoundException extends RuntimeException{
	
    public FoodCartNotFoundException() {
    	super();
    }
    
    public FoodCartNotFoundException(String message) {

    	super(message);
    }
    public FoodCartNotFoundException(Throwable cause) {
    	
    	super(cause);
    }
}
