package com.sprint.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.entity.*;
import com.sprint.exception.RestaurantNotFoundException;
import com.sprint.service.IRestaurantService;

/* 
 * @RestController- for HTTP restful 
 * @Autowired- for autowiring
 * @GetMapping- annotation ensures HTTP GET requests
 * @PostMapping- annotation ensure HTTP POST requests
 * @DeleteMapping- annotation ensures HTTP DELETE requests
 * @PathVariable- handle variables in the request URI mapping
 * @RequestBody- method parameter bounds to the body of the HTTP request
 * 
 */
@CrossOrigin
@RestController
public class RestaurantController {

	  // Define the log object for this class
	   Logger log = LoggerFactory.getLogger(RestaurantController.class);
	
	@Autowired
	IRestaurantService restServ;

	/* Get All Restaurant 
	 * returns List of Restaurant 
	 */
	@GetMapping("/restaurant/all")
	public List<Restaurant> getAllRestaurant() {
		log.info("Getting all  Restaurants");
		return restServ.getAllRestaurant();
	
	}

	/*
	 *  Get Restaurant based on Id
	 */
	@GetMapping("/restaurant/getById/{id}")
	public ResponseEntity<Restaurant> getRestById(@PathVariable("id") int id) {
		Restaurant rest = restServ.getRestById(id);

		if (rest == null) {
			throw new RestaurantNotFoundException("Invalid restaurant id : " + id);
		}
		log.info("Getting Restaurant By Id");
		return new ResponseEntity<>(restServ.getRestById(id), HttpStatus.OK); // 200 OK

	}

/*
 * Get Restaurant based on restaurants name
 */
	
	@GetMapping("/restaurant/getByName/{name}")
	public ResponseEntity<Restaurant> getRestByName(@PathVariable("name") String name) {
		log.info("Getting Restaurant By Name");

		return new ResponseEntity<>(restServ.getRestByName(name), HttpStatus.OK); // 200 OK
	}

	/* 
	 *  Add restaurant with all the details 
	 *  Post method to add restaurant
	 *   returns object of Restaurant
	 */

	@PostMapping("/restaurant/add")
	public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody Restaurant rest) {
		Restaurant restaurant =  restServ.addRestaurant(rest);
		log.info("Adding Restaurant ");
		return new ResponseEntity<Restaurant>(restaurant,HttpStatus.OK);
		
	}
	
/* 
 *  Remove Restaurants detail by  using Id
 */
	@DeleteMapping("/restaurant/delete/byId/{id}")
	public ResponseEntity<Restaurant>  removeRestaurantById(@PathVariable("id") int id) {
		Restaurant restaurant =restServ.removeRestaurantById(id);
		log.info("Removing Restaurant By Id");
		return new ResponseEntity<Restaurant>( restaurant,HttpStatus.OK); //200 OK

	}

	/* 
	 *  Remove Restaurants detail by  using  name
	 */
	@DeleteMapping("/restaurant/delete/byName/{name}")
	public ResponseEntity<Restaurant> removeRestaurantByName(@PathVariable("name") String name) {
		log.info("Getting Restaurant By Name");
		return new ResponseEntity<Restaurant>( restServ.removeRestaurantByName(name),HttpStatus.OK); //200 OK

	}

/*
 *  Update restaurant 
 */
	@PutMapping("/restaurant/update")
	public Restaurant updateRestaurant(@Valid @RequestBody Restaurant rest) {
		log.info("Updating Restaurant");
		return restServ.updateRestaurant(rest);
	}

	/* 
	 *  Get restaurants byArea
	 */
	@GetMapping("/restaurant/byArea")
	public List<Restaurant> getRestaurantByArea(String area) {
		log.info("Getting Restaurants By area "+area);
		return restServ.getRestaurantByArea(area);
	}

	/*
	 *  Get restaurants byCity
	 */
	@GetMapping("/restaurant/city/byCity")
	public List<Restaurant> getRestaurantByCity(String city) {
		log.info("Getting Restaurants By city "+city);
		return restServ.getRestaurantByCity(city);
	}
}
