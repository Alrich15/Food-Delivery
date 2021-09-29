package com.sprint.service;


import java.util.List;

import javax.validation.Valid;

import com.sprint.entity.FoodCart;
import com.sprint.entity.Item;
import com.sprint.entity.ItemCategory;
import com.sprint.entity.Restaurant;


/*
 *   This is Service interface for Item
 *   Here, structure of methods to be initilized are defined
 *
 */
public interface IItemService {

	//add  new Food Item
	Item addItem(Item item);
	
	//update existing Item
	Item updateItem(Item item);
	
	//view Item by entering item name
	Item viewItem(String itemName);
	
	//get Item by itemid
	public Item getItemById(String itemId);
	// remove item with given item id
	Item removeItem(String itemId);
	

		
	//update item qty
			public void updateQuantity(int qty,String itemId);
	//remove item with given item name
	Item removeItemByName(String itemName);
	
	//list all items
	List<Item> viewAllItems();

	//View all items in the given cart(by entering cart id) sorted by cost of cart items
	List<Item> viewCartItemsByCostAsc(String cartId);
	
	//Search a specific item in a cart by passing cart id and name of item
	Item searchCartItem(String cartId,String itemName);
	
	//Search list of items by given item category in a cart 
	List<Item> searchcartItemByCateg(String cartId,String itemCategory);
	
	
	
	List<Item> getItemsByRestId(Integer restId);
	List<Item> getItemsByCategory(String catId);
	List<Item> findAllItemsSortedByPrice();
	List<Item> findByRestIdAndCategoryId(Integer restId,String catId);
	List<Item> findByRestIdAndSortedByPriceAscending(Integer restId);
	List<Item> findByRestIdAndSortedByPriceDescending(Integer restId);


	FoodCart addItemToCart(String cartId, @Valid Item item);

}
