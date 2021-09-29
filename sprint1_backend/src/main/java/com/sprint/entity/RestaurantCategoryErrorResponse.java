package com.sprint.entity;

import lombok.Data;

@Data

public class RestaurantCategoryErrorResponse {

	private int status;
	private String message;
	private long timeStamp;
}
