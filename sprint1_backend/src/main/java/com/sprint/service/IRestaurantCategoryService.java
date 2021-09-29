package com.sprint.service;

import java.util.List;

import com.sprint.entity.RestaurantCategory;


public interface IRestaurantCategoryService {
	// Add restaurant category
	public RestaurantCategory addRestaurantCategory(RestaurantCategory category);
	//update restaurant category
	public RestaurantCategory updateRestaurantCategory(RestaurantCategory category);
	//remove restaurant category by Id
	public RestaurantCategory removeRestaurantCategoryById(String restCategoryId);
	//remove restaurant category by Name
	public RestaurantCategory removeRestaurantCategoryByName(String restCategoryName);
	//Get all restaurant categories
	public List<RestaurantCategory> getAllRestaurantCategories();
	//Get restaurant category by Id
	public RestaurantCategory getRestaurantCategoryById(String restCategoryId);

}
