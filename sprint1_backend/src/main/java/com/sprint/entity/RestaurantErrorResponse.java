package com.sprint.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 *  @Data- Generates getters,setters for all fields, a useful toString method, and hashCode and equals implementations
 *  @AllArgsConstructor-lombok generates a parameterized constructor.
 *  @NoArgsConstructor -lombok generates an empty constructor
 *  
 */

/*
 *   
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RestaurantErrorResponse {
	
	// Fields
	
	private int status;
	private String message;
	private long timeStamp;

	
	
}