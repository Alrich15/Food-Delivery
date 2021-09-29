package com.sprint.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCartErrorResponse {

	private int status;
	private String message;
	private long timeStamp;

}
