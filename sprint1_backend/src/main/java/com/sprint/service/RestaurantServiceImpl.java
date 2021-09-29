package com.sprint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dao.IRestaurantDao;
import com.sprint.entity.Address;
import com.sprint.entity.Restaurant;
import com.sprint.entity.RestaurantCategory;
import com.sprint.exception.RestaurantAlreadyExistsException;
import com.sprint.exception.RestaurantCategoryAlreadyExistsException;
import com.sprint.exception.RestaurantCategoryNotFoundException;
import com.sprint.exception.RestaurantNotFoundException;

/*
 * @Service- used to mark this class as a service provider class
 */


// Implementing RestaurantService Interface

@Service
public class RestaurantServiceImpl implements IRestaurantService {

	@Autowired
	IRestaurantDao restDao;
	
	//Get all restaurants
	@Override
	public List<Restaurant> getAllRestaurant() {
		return restDao.findAll();
	}

	//Get restaurant by Id
	@Override
	public Restaurant getRestById(int restaurantId) {
		List<Restaurant> opt = restDao.findByRestaurantId(restaurantId);
		if(opt.isEmpty()) {
			throw new RestaurantNotFoundException("Restaurant not found with the given id: "+restaurantId);
		}
	return (Restaurant) opt;
	}

	//Get restaurant by Name
	@Override
	public Restaurant getRestByName(String restaurantName) {
		Optional<Restaurant> opt = restDao.findByRestaurantName(restaurantName);
	if(!opt.isPresent()) {
			throw new RestaurantNotFoundException("Restaurant not found with the given name: "+restaurantName);
		}
	return opt.get();
	
	}

	
	//Add restaurants
	@Override
	public Restaurant addRestaurant( Restaurant restaurant) {
		
		Optional<Restaurant> opt = restDao.findById(restaurant.getRestaurantId());
		if(opt.isPresent())
		{
			throw new RestaurantAlreadyExistsException("Restaurant with given id already exists : " + restaurant.getRestaurantId());
		}
		else
		{	
			return restDao.save(restaurant);
		}	
	}

	//Remove restaurants by Id
	@Override
	public Restaurant removeRestaurantById(int restaurantId) {
		
		Optional<Restaurant> rest=restDao.findById(restaurantId);
		if(rest.isPresent())
		{
			Restaurant tempRestaurant = rest.get();
			tempRestaurant.setAddress(new Address("ADD112", "rajhni", "90", "Ghatkopar", "Mumbai", "Maharashtra", "India", "400075"));
			//tempRestaurant.setRestCat(null);
			tempRestaurant.setItemList(null);
			restDao.delete(tempRestaurant);
			return tempRestaurant;
		}
		throw new RestaurantNotFoundException("Restaurant  not found with Id "+restaurantId);

	}

	

	//Remove restaurants by Name
	@Override
	public Restaurant removeRestaurantByName(String restaurantName) {

		Optional<Restaurant> rest=restDao.findByRestaurantName(restaurantName);
		if(rest.isPresent())
		{
			Restaurant tempRestaurant = rest.get();
			tempRestaurant.setAddress(null);
		//	tempRestaurant.setRestCat(null);
			tempRestaurant.setItemList(null);
			restDao.delete(tempRestaurant);
			return tempRestaurant;
			
		}
		throw new RestaurantNotFoundException("Restaurant  not found with Name "+restaurantName);
	}

	//Update Restaurants
	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		//Find Restaurant
		Optional<Restaurant> opt=restDao.findById(restaurant.getRestaurantId());
		//Update Restaurant Details
		if(opt.isPresent()) {
			Restaurant dbRest= opt.get();
			dbRest.setRestaurantName(restaurant.getRestaurantName());
			dbRest.setContactNumber(restaurant.getContactNumber());
			dbRest.setManagerName(restaurant.getManagerName());
			
			//save
			restDao.save(dbRest);
		}
		else{
			throw new RestaurantNotFoundException("Restaurant with given id not found : " + restaurant.getRestaurantId());
		}
		return restaurant;
	}
	
	// Get restaurant by area
	@Override
	public List<Restaurant> getRestaurantByArea(String area) {
		return restDao.getRestaurantByArea(area);
	}
	
	//Get restaurant by city
	@Override
	public List<Restaurant> getRestaurantByCity(String city) {
		return restDao.getRestaurantByCity(city);
	}



	
	

}
