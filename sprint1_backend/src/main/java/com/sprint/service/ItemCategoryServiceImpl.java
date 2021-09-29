package com.sprint.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dao.IItemCategoryDAO;
import com.sprint.entity.ItemCategory;
import com.sprint.exception.ItemCategoryAlreadyExistsException;
import com.sprint.exception.ItemCategoryNotFoundException;

@Service
public class ItemCategoryServiceImpl implements IItemCategoryService {
	
	@Autowired
	IItemCategoryDAO itemCategoryDao;
	
	

	/*Add Item Category
	 *itemCategory - object of ItemCategory
	 * returns object of ItemCategory when added in database
	 */
	@Override
	public ItemCategory addItemCategory(ItemCategory category) {
		Optional<ItemCategory> item = itemCategoryDao.findById(category.getItemCategoryId());
		//If item category already exists with given id then throws exception
		if(item.isPresent()) {
			//logger.info("Item category already exists with id "+category.getItemCategoryId());
			throw new ItemCategoryAlreadyExistsException("Item category already exists with id "+category.getItemCategoryId());
		}
		return itemCategoryDao.save(category);
	}

	/*Update existing Item Category
	 *itemCategory - object of ItemCategory
	 * returns object of ItemCategory after successful update
	 */
	@Override
	public ItemCategory updateItemCategory(ItemCategory category) {
		Optional<ItemCategory> item = itemCategoryDao.findById(category.getItemCategoryId());
		if(item.isPresent()) {
			ItemCategory tempItem = item.get();
			tempItem.setItemCategoryName(category.getItemCategoryName());
			return itemCategoryDao.save(tempItem);
		}
		//If item is not present with with category id then throws exception
		throw new ItemCategoryNotFoundException("Item category not found with id "+category.getItemCategoryId());		
	}


	/* Get All ItemCategories
	 * returns List of Item Categories
	 */
	@Override
	public List<ItemCategory> getAllItemCategories() {
		return itemCategoryDao.findAll();
	}

	/*get Item Category by Id
	 * itemCategoryId - Id of existing item category
	 * returns object of ItemCategory if present with given id
	 */
	@Override
	public ItemCategory getItemCategoryById(String itemCategoryId) {
		Optional<ItemCategory> item = itemCategoryDao.findById(itemCategoryId);
		//If item is not present with given id then throws exception
		if(!item.isPresent()) {
			throw new ItemCategoryNotFoundException("Item category not found with id "+itemCategoryId);
		}
		return item.get();
	}
	

	/*Remove Item Category by Id
	 * itemCategoryId - Id of existing item category
	 * returns object of ItemCategory when removed from database
	 */
	@Override
	public ItemCategory removeItemCategoryById(String itemCategoryId) {
		Optional<ItemCategory> item = itemCategoryDao.findById(itemCategoryId);
		if(item.isPresent()) {
			itemCategoryDao.delete(item.get());
			return item.get();
		}
		//If item is not present with given id then throws exception
		throw new ItemCategoryNotFoundException("Item category not found with id "+itemCategoryId);
		
		
	}

	/*Remove Item Category by Name
	 * name - name of existing item category
	 * returns object of ItemCategory when removed from database
	 */
	@Override
	public ItemCategory removeItemCategoryByName(String itemCategoryName) {
		ItemCategory item = itemCategoryDao.findByItemCategoryName(itemCategoryName);
		//If item is not present with given name then throws exception
		if(item == null) {
			throw new ItemCategoryNotFoundException("Item category not found with Name "+itemCategoryName);
		}
		itemCategoryDao.delete(item);	
		return item;
	}

	

}
