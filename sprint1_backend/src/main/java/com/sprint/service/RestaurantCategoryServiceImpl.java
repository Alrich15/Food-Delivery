package com.sprint.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.controller.RestaurantController;
import com.sprint.dao.IRestaurantCategoryDAO;
import com.sprint.dao.IRestaurantDao;
import com.sprint.entity.Restaurant;
import com.sprint.entity.RestaurantCategory;
import com.sprint.exception.RestaurantCategoryAlreadyExistsException;
import com.sprint.exception.RestaurantCategoryNotFoundException;

@Service
public class RestaurantCategoryServiceImpl implements IRestaurantCategoryService {
	
	@Autowired
	IRestaurantCategoryDAO restDao;
	@Autowired
	IRestaurantDao resDao;
	   Logger log = LoggerFactory.getLogger(RestaurantCategoryServiceImpl.class);
	
	/*Add Restaurant Category
	 * category - object of restaurantCategory
	 * returns object of RestaurantCategory when added in database
	 */
	@Override
	public RestaurantCategory addRestaurantCategory(RestaurantCategory category) {
		Optional<RestaurantCategory> rest = restDao.findById(category.getRestaurantCategoryId());
		if(rest.isEmpty())
		{
			List<Restaurant> restaurant =new ArrayList<>();
			List<Integer> restaurantId= category.getRest().stream().map(r->r.getRestaurantId() ).collect(Collectors.toList());
			Restaurant res=new Restaurant();
			log.info(" "+restaurantId);
			for(int  r: restaurantId) {
//				
	//	res= resDao.getById(r);
		//log.info(" "+res);
		restaurant.add( resDao.getById(r));
		//log.info(" "+restaurant);
		//System.out.print(res);
//			
		}
			category.setRest(restaurant);
			return restDao.save(category);
			
		}
		else
			//throws exception RestaurantCategoryAlreadyExistsException if restaurant category already present in database with given id
			throw new RestaurantCategoryAlreadyExistsException("Restaurant category with id "+category.getRestaurantCategoryId()+" already exists.");
	}

	/*Update existing Restaurant Category
	 *category - object of restaurantCategory
	 * returns object of RestaurantCategory when updated
	 */
	@Override
	public RestaurantCategory updateRestaurantCategory(RestaurantCategory category) {
		Optional<RestaurantCategory> rest = restDao.findById(category.getRestaurantCategoryId());
		if(rest.isPresent()) {
			RestaurantCategory tempRestaurant = rest.get();
			tempRestaurant.setRestaurantCategoryName((category.getRestaurantCategoryName()));;
			return restDao.save(tempRestaurant);
		}
		//throws exception RestaurantCategoryNotFoundException if restaurant category not found with given id
		throw new RestaurantCategoryNotFoundException("Restaurant category not found with id "+category.getRestaurantCategoryId());
	}

	/* Remove Restaurant Category by Id
	 * restCategoryId - restaurant category Id
	 * returns object of RestaurantCategory 
	 */
	@Override
	public RestaurantCategory removeRestaurantCategoryById(String restCategoryId) {
		Optional<RestaurantCategory> rest = restDao.findById(restCategoryId);
		if(rest.isPresent()) {
			RestaurantCategory tempRestaurant = rest.get();
			restDao.delete(tempRestaurant);
			return tempRestaurant;
		}
		//throws exception RestaurantCategoryNotFoundException if restaurant category not found with given Id
		throw new RestaurantCategoryNotFoundException("Restaurant category not found with Id "+restCategoryId);
	}

	/* Remove Restaurant Category by Name
	 * restCategoryName - restaurant category name
	 * returns object of RestaurantCategory 
	 */
	@Override
	public RestaurantCategory removeRestaurantCategoryByName(String restCategoryName) {
		RestaurantCategory rest = restDao.findByRestaurantCategoryName(restCategoryName);
		//throws exception RestaurantCategoryNotFoundException if restaurant category not found with given name
		if(rest == null) {
			throw new RestaurantCategoryNotFoundException("Restaurant category not found with Name "+restCategoryName);
		}
		restDao.delete(rest);
		return rest;

	}

	/* Get All Restaurant Categories
	 * returns List of Restaurant Categories
	 */
	@Override
	public List<RestaurantCategory> getAllRestaurantCategories() {
		return restDao.findAll();
	}

	/*Get Restaurant Category by Id
	 * restCategoryId - restaurant category Id
	 * returns object of RestaurantCategory 
	 */
	@Override
	public RestaurantCategory getRestaurantCategoryById(String restCategoryId) {
		Optional<RestaurantCategory> rest = restDao.findById(restCategoryId);
		if(rest.isPresent()) {
			return rest.get();
		}
		throw new RestaurantCategoryNotFoundException("Restaurant category not found with Id "+restCategoryId);
	}

}
