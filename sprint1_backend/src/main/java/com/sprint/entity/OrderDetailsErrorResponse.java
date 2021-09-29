package com.sprint.entity;

import lombok.Data;

@Data  //Injects all the getters and setters methods
public class OrderDetailsErrorResponse {
	
	//Fields
	private int status;
	private String message;
	private long timeStamp;
	
	//Default Constructor
	public OrderDetailsErrorResponse() {
		
	}

	//Constructors with fields
	public OrderDetailsErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	

}
	