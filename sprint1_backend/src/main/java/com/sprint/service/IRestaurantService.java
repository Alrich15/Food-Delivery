package com.sprint.service;

import java.util.List;


import com.sprint.entity.Restaurant;
/*
 * Defining an interface for the services of the Restaurant class
 */
public interface IRestaurantService {

	//To get all the restaurants
	List<Restaurant> getAllRestaurant();

	// To Get restaurant based on restaurantId
	Restaurant getRestById(int restaurantId);

	// To get restaurant based on restaurantName
	Restaurant getRestByName(String restaurantName);

	// To add Restaurant 
	Restaurant addRestaurant(Restaurant restaurant);// Done

	// To update Restaurant
	Restaurant updateRestaurant(Restaurant restaurant);

	// remove restaurant based on restaurantId
	Restaurant removeRestaurantById(int restaurantId);

	// remove restaurant based on restaurantName
	Restaurant removeRestaurantByName(String restaurantName);

	// get list of restaurant by area name
	List<Restaurant> getRestaurantByArea(String area);

	// get list f restaurant by city name
	List<Restaurant> getRestaurantByCity(String city);

}
