package com.sprint.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.entity.ItemCategory;
import com.sprint.service.ItemCategoryServiceImpl;

@CrossOrigin
@RestController
public class ItemCategoryController {
	
	@Autowired
	ItemCategoryServiceImpl itemCategoryService;
	
	Logger logger = LoggerFactory.getLogger(ItemCategory.class);
	
	/* Get All ItemCategories
	 * returns List of Item Categories
	 */
	@GetMapping("/itemCategory/all")
	public ResponseEntity<List<ItemCategory>> getAllItemCategories(){
		logger.info("logger in controller get all items");
		return new ResponseEntity<List<ItemCategory>>(itemCategoryService.getAllItemCategories(),HttpStatus.OK);
	}
	
	/*Add Item Category
	 * @RequestBody itemCategory - object of ItemCategory
	 * returns object of ItemCategory when added in database
	 */
	@PostMapping("/itemCategory/add")
	public ResponseEntity<ItemCategory> addItemCategory(@Valid @RequestBody ItemCategory itemCategory){
		ItemCategory item = itemCategoryService.addItemCategory(itemCategory);
		return new ResponseEntity<ItemCategory>(item,HttpStatus.OK);
	}
	
	/*Update existing Item Category
	 * @RequestBody itemCategory - object of ItemCategory
	 * returns object of ItemCategory after successful update
	 */
	@PutMapping("/itemCategory/update")
	public ResponseEntity<ItemCategory> updateItemCategory(@Valid @RequestBody ItemCategory itemCategory) {
		ItemCategory item = itemCategoryService.updateItemCategory(itemCategory);
		return new ResponseEntity<ItemCategory>(item,HttpStatus.OK);
	}
	
	/*find Item Category by Id
	 * @PathVariable itemCategoryId - Id of existing item category
	 * returns object of ItemCategory if present with given id
	 */
	@GetMapping("/itemCategory/byId/{id}")
	public ResponseEntity<ItemCategory> getItemCategoryById(@PathVariable("id") String itemCategoryId){
		ItemCategory item =itemCategoryService.getItemCategoryById(itemCategoryId);
		return new ResponseEntity<ItemCategory>(item,HttpStatus.OK);
	}
	
	/*Remove Item Category by Id
	 * @PathVariable itemCategoryId - Id of existing item category
	 * returns object of ItemCategory when removed from database
	 */
	@DeleteMapping("/itemCategory/remove/byId/{id}")
	public ResponseEntity<ItemCategory> removeItemCategoryById(@PathVariable("id") String itemCategoryId) {
		ItemCategory item =itemCategoryService.removeItemCategoryById(itemCategoryId);
		return new ResponseEntity<ItemCategory>(item,HttpStatus.OK);
	}
	
	/*Remove Item Category by Name
	 * @PathVariable name - name of existing item category
	 * returns object of ItemCategory when removed from database
	 */
	@DeleteMapping("/itemCategory/remove/byName/{name}")
	public ResponseEntity<ItemCategory> removeItemCategoryByName(@PathVariable("name") String itemCategoryName) {
		ItemCategory item =itemCategoryService.removeItemCategoryByName(itemCategoryName);
		return new ResponseEntity<ItemCategory>(item,HttpStatus.OK);
	}

}
