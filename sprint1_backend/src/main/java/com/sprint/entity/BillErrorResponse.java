package com.sprint.entity;

import lombok.Data;
//@Data - for getters,setters,equals,toString and hashCode
@Data
public class BillErrorResponse {
	/*Class for returning proper error response
	 * status for displaying status (example:400,500)
	 * message for displaying error message
	 * timestamp for displaying time stamp
	 */
	
	private int status;
	private String message;
	private long timeStamp;
}