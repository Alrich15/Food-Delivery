package com.sprint.entity;

import lombok.Data;

@Data
public class LoginErrorResponse {
	
	// Fields
	private int status;
	private String message;
	private long timeStamp;

}
