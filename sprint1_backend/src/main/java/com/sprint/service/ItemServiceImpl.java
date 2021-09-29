package com.sprint.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dao.ICartDao;
import com.sprint.dao.IItemDao;
import com.sprint.entity.FoodCart;
import com.sprint.entity.Item;
import com.sprint.entity.ItemCategory;
import com.sprint.entity.Restaurant;
import com.sprint.exception.FoodCartNotFoundException;
import com.sprint.exception.ItemAlreadyExistsException;
import com.sprint.exception.ItemCategoryNotFoundException;
import com.sprint.exception.ItemNotFoundException;

/*
*		Implementation of Service interface for Food Items
*		Overriding all the service interface methods
*
*/

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	IItemDao itemDao;
	ICartDao cartDao;

	
	
	/*
	 * 		Adding a new item
	 */
	@Override
	public Item addItem(Item item) {
		
		//check if item already exists 
		 Optional<Item> optItem = itemDao.findById(item.getItemId()); 
		 if(optItem.isPresent()) { 
			   throw new ItemAlreadyExistsException("Item already exists with the given item id: "+ item.getItemId());
		} 
		
		 // persist the new item into database by calling its dao method
		return itemDao.save(item);
	}

	/*
	 * 		Updating an existing item
	 */
	@Override
	public Item updateItem(Item item) {
		// Find Item
		Optional<Item> optItem = itemDao.findById(item.getItemId());
		// Update item details
		 if (optItem.isPresent()) {
			  Item dbItem = optItem.get();
				dbItem.setItemId(item.getItemId());
				dbItem.setItemName(item.getItemName());
				dbItem.setCost(item.getCost());
				dbItem.setImage(item.getImage());  	
				dbItem.setItemDesc(item.getItemDesc());
				itemDao.save(dbItem);
				return item;
			   }
		 // If item not present print message
		 throw new ItemNotFoundException("Please insert a valid name!  Food Item " + item.getItemName() + " not found");
	}
	
	
	/*
	 *		 Viewing item details by given item name
	 */
	@Override
	public Item viewItem(String itemName) {
		
		//calling viewItem from Item repository
		Item item=itemDao.viewItem(itemName);
		
		//If not found throw ItemNotFoundException with print message
		if(item == null) {
			throw new ItemNotFoundException("Please insert a valid name!  Food Item " + itemName + " not found");
		}
		return item;
	}

	/*
	 * 		Remove item by given item name
	 */
	@Override
	public Item removeItemByName(String itemName) {
		//check if given item exists
		Item item=itemDao.viewItem(itemName);
		//If item not found then throw ItemNotFound exception with print message
		if(item == null) {
			throw new ItemNotFoundException("Please insert a valid name!  Food Item " + itemName + " not found");
		}
			
		itemDao.deleteById(item.getItemId());
		return item;
	}


	/*
	 *		 Remove item by given item id
	 */
	@Override
	public Item removeItem(String itemId) {
		//Check if given item id exists
		Optional<Item> opt = itemDao.findById(itemId);
		
		//If not found throw ItemNotFoundException with print message
		if(!opt.isPresent()) { 
			  throw new ItemNotFoundException("Please insert valid details!  Food Item id: " + itemId + " not found"); 
			
		}
		
		//If found then delete it 
				itemDao.deleteById(itemId);
				return opt.get();
				
			}
	/*
	 * 		List all items stored into database
	 */
	@Override
	public List<Item> viewAllItems() {
		// Calling findAll from Item Repository to list all items
		return itemDao.findAll();
	}

	
	/*
	 * 		View all the items from cart 
	 * 		Sorted by their cost Ascending order
	 */
	@Override
	public List<Item> viewCartItemsByCostAsc(String cartId) {
		return itemDao.viewCartItemsByCostAsc(cartId);
	}


	/*
	 * 		Search for item by given item name
	 *  	from cart by cart id
	 */
	@Override
	public Item searchCartItem(String cartId, String itemName) {
		//Check if item exists
		Item item=itemDao.viewItem(itemName);
		//If not present throw ItemNotFoundException
		if(item == null) {
			throw new ItemNotFoundException("Food Item " + itemName + " not found");
		}
		return itemDao.searchCartItem(cartId, itemName);
	}
	
	
	/*
	 * 		Search for list of items in a cart 
	 * 		by specific item category
	 */
	@Override
	public List<Item> searchcartItemByCateg(String cartId,String itemCategory) {
		return itemDao.searchCartItemByCateg(cartId, itemCategory);
	}
	
	
	/* List out Items 
	   * based on Restaurant Id
	   */
	public List<Item> getItemsByRestId(Integer restId){
		return itemDao.findItemsByRestId(restId);
	}
	
	
	/* List out Items 
	   * based on item category Id
	   */
	public List<Item> getItemsByCategory(String catId){
		return itemDao.findByItemCategoryId(catId);
	}

	
	 /*
	   * Get list of sorted Items Ascending
	   */
	@Override
	public List<Item> findAllItemsSortedByPrice() {
		return itemDao.findAllItemsSortedByPrice();
	}

	
	/*
	   *get list of Items by Restaurant id and item category id 
	   */
	@Override
	public List<Item> findByRestIdAndCategoryId(Integer restId, String catId) {
		return itemDao.findByRestIdAndCategoryId(restId, catId);
	}

	/*
	   *get list of Items by Restaurant id in ascending order
	   */
	@Override
	public List<Item> findByRestIdAndSortedByPriceAscending(Integer restId) {
		return itemDao.findByRestIdAndSortedByPriceAscending(restId);
	}

	@Override
	public void updateQuantity(int qty,String itemId) {
		 itemDao.updateQuantity(qty,itemId);
	}
	
	/*
	   *get list of Items by Restaurant id in descending order
	   */
	@Override
	public List<Item> findByRestIdAndSortedByPriceDescending(Integer restId) {
		return itemDao.findByRestIdAndSortedByPriceDescending(restId);
	}
    /*
	 * This method will add item to cart and return foodcart
	 */
	


	//IItemDao itemDao;
	@Override
	public Item getItemById(String itemId) {
		Optional<Item> item = itemDao.findById(itemId);
		//If item is not present with given id then throws exception
		if(!item.isPresent()) {
			throw new ItemCategoryNotFoundException("Item  not found with id "+itemId);
		}
		return item.get();
		
	}
	
	@Override
	public FoodCart addItemToCart(String cartId, Item item) {
		Optional<FoodCart> opt = cartDao.findByCartId(cartId);
		if(opt.isPresent()) {
			//Item itemDetail =cartDao.findItemById(item.getItemId());
			//FoodCart cartDetail=cartDao.findCartById(cartId);
			FoodCart cart=opt.get();
			cart.getCartItems().add(item);
			cart.setTotalAmount(cart.getTotalAmount()+(item.getQty()*item.getCost()));
			 return cartDao.save(cart);
		}
		else {
			throw new FoodCartNotFoundException("Food cart not found with given id:"+cartId);
		}
	}
	
	
	
	
	
	

}
