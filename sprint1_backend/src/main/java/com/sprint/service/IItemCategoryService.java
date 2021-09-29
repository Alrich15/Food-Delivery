package com.sprint.service;

import java.util.List;

import com.sprint.entity.ItemCategory;

public interface IItemCategoryService {
	
	// Add Item Category 
	public ItemCategory addItemCategory(ItemCategory category);
	// Update existing item category
	public ItemCategory updateItemCategory(ItemCategory category);
	//Remove item category with given Id
	public ItemCategory removeItemCategoryById(String itemCategoryId);
	//Remove item category with given name
	public ItemCategory removeItemCategoryByName(String itemCategoryName);
	//view all item category 
	public List<ItemCategory> getAllItemCategories();
	//view item category By Id
	public ItemCategory getItemCategoryById(String itemCategoryId);

}
