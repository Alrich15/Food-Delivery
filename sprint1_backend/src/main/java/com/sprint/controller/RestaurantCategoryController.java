package com.sprint.controller;

import java.util.List;

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

import com.sprint.entity.ItemCategory;
import com.sprint.entity.RestaurantCategory;
import com.sprint.service.RestaurantCategoryServiceImpl;

@CrossOrigin
@RestController
public class RestaurantCategoryController {
	
	@Autowired
	RestaurantCategoryServiceImpl restCategoryService;
	
	/* Get All Restaurant Categories
	 * returns List of Restaurant Categories
	 */
	
	@GetMapping("/restCategory/all")
	public ResponseEntity<List<RestaurantCategory>> getAllRestaurantCategories(){
		return new ResponseEntity<List<RestaurantCategory>>(restCategoryService.getAllRestaurantCategories(),HttpStatus.OK);
	}
	
	/*Add Restaurant Category
	 * @RequestBody restaurantCategory - object of restaurantCategory
	 * returns object of RestaurantCategory when added in database
	 */
	@PostMapping("/restCategory/add")
	public RestaurantCategory addRestaurantategory( @RequestBody RestaurantCategory restCategory) {
		RestaurantCategory rest =  restCategoryService.addRestaurantCategory(restCategory);
	//	return new ResponseEntity<RestaurantCategory>(rest,HttpStatus.OK);
	return rest;
	 }
	
	/*Update existing Restaurant Category
	 * @RequestBody restaurantCategory - object of restaurantCategory
	 * returns object of RestaurantCategory when updated
	 */
	@PutMapping("/restCategory/update")
	public ResponseEntity<RestaurantCategory> updateRestaurantCategory(@Valid @RequestBody RestaurantCategory restCategory) {
		RestaurantCategory rest = restCategoryService.updateRestaurantCategory(restCategory);
		return new ResponseEntity<RestaurantCategory>(rest,HttpStatus.OK);
	}
	
	/*Get Restaurant Category by Id
	 * @PathVariable restId - restaurant category Id
	 * returns object of RestaurantCategory 
	 */
	@GetMapping("/restCategory/byId/{restId}")
	public ResponseEntity<RestaurantCategory> getRestaurantCategoryById(@PathVariable("restId") String restCategoryId){
		RestaurantCategory rest = restCategoryService.getRestaurantCategoryById(restCategoryId);
		return new ResponseEntity<RestaurantCategory>(rest,HttpStatus.OK);
	}
	
	/* Remove Restaurant Category by Id
	 * @PathVariable restId - restaurant category Id
	 * returns object of RestaurantCategory 
	 */
	@DeleteMapping("/restCategory/remove/byId/{restId}")
	public ResponseEntity<RestaurantCategory> removeRestaurantCategoryById(@PathVariable("restId") String restCategoryId) {
		RestaurantCategory rest = restCategoryService.removeRestaurantCategoryById(restCategoryId);
		return new ResponseEntity<RestaurantCategory>(rest,HttpStatus.OK);
	}
	
	/*Remove Restaurant Category by Name
	 * @PathVariable restName - restaurant category Name
	 * returns object of RestaurantCategory 
	 */
	@DeleteMapping("/restCategory/remove/byName/{restName}")
	public ResponseEntity<RestaurantCategory> removeRestaurantCategoryByName(@PathVariable("restName") String restCategoryName) {
		RestaurantCategory rest = restCategoryService.removeRestaurantCategoryByName(restCategoryName);
		return new ResponseEntity<RestaurantCategory>(rest,HttpStatus.OK);
	}

}
