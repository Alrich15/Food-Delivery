package com.sprint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.entity.FoodCart;
import com.sprint.entity.Item;
import com.sprint.entity.ItemCategory;
import com.sprint.service.IItemService;

@CrossOrigin
@RestController
public class ItemController {

	@Autowired
	IItemService itemServ;
		// Add Item
		@PostMapping("/item/add")
		public ResponseEntity<Item> addItem(@Valid @RequestBody Item item) {
			return new ResponseEntity<>(itemServ.addItem(item),HttpStatus.OK);
		}
		
		@GetMapping("/item/byId/{id}")
		public ResponseEntity<Item> getItemById(@PathVariable("id") String itemId){
			Item item =itemServ.getItemById(itemId);
			return new ResponseEntity<Item>(item,HttpStatus.OK);
		}
	
@PatchMapping("/item/updateqty/{id}/{qt}")
	  public void updateQty( @PathVariable("qt") int qty,@PathVariable("id") String itemId){
		   itemServ.updateQuantity(qty,itemId);
	  }
		 //update
		  @PutMapping("/item/update")
		  public ResponseEntity<Item> updateItem(@Valid @RequestBody Item item) {
			  //return itemServ.updateItem(item);
			  return new ResponseEntity<>(itemServ.updateItem(item), HttpStatus.OK);
		  }
			
		
		// Delete item based on itemId
		@DeleteMapping("/item/remove/byId/{id}")
		public ResponseEntity<Item> removeItem(@PathVariable("id") String itemId) {
			return new ResponseEntity<>(itemServ.removeItem(itemId), HttpStatus.OK);
			//return itemServ.removeItem(itemId);
		}
		
		//Delete by name
		  @DeleteMapping("/item/remove/{name}")
		  public ResponseEntity<Item> removeItemByName(@PathVariable("name") String itemName) {
			 // return itemServ.removeItemByName(itemName);
			  return new ResponseEntity<>(itemServ.removeItemByName(itemName), HttpStatus.OK);
		  }
		
		  //view Item by name
		  @GetMapping("/item/byName/{name}")
		  public ResponseEntity<Item> viewItem(@Valid @PathVariable("name") String itemName) {
			  return new ResponseEntity<>(itemServ.viewItem(itemName), HttpStatus.OK);
		  }
		  
		 // Getting all items 
		  @GetMapping("/item/all") 
		  public List<Item> viewAllItems() { 
			  return itemServ.viewAllItems();
			  }
		 
		
		  @GetMapping("/foodcart/{cartid}/Asc")
			public List<Item> viewItemsByCostAsc(@PathVariable("cartid") String cartId){
				return itemServ.viewCartItemsByCostAsc(cartId);
			}
		  
		  @GetMapping("/foodcart/search/{name}")
		  public Item searchCartItem(String cartId,@PathVariable("name") String itemName) {
			  return itemServ.searchCartItem(cartId, itemName);
		  }
		  
		  @GetMapping("/foodcart/search/byCategory/{category}")
		  public List<Item> searchcartItemByCateg(String cartId,@PathVariable("category") String itemCategory) {
			  return itemServ.searchcartItemByCateg(cartId,itemCategory);
		  }
		  
		  /* List out Items 
		   * based on Restaurant Id
		   */
		  @GetMapping("/item/restId/{restId}")
		  public ResponseEntity<List<Item>> getItemsByRestId(@Valid @PathVariable("restId") int restId){
			  return new ResponseEntity<>(itemServ.getItemsByRestId(restId), HttpStatus.OK);
		  }
		  
		  /* List out Items 
		   * based on item category Id
		   */
		  @GetMapping("/item/categoryId/{catId}")
		  public ResponseEntity<List<Item>> getItemsByCategoryId(@Valid @PathVariable("catId") String catId){
			  return new ResponseEntity<>(itemServ.getItemsByCategory(catId), HttpStatus.OK);
		  }
		  
		  /*
		   * Get list of sorted Items Ascending
		   */
		  @GetMapping("/item/sortedByPriceAscending")
		  public ResponseEntity<List<Item>> findAllItemsSortedByPrice(){
			  return new ResponseEntity<>(itemServ.findAllItemsSortedByPrice(), HttpStatus.OK);
		  }
		  
		  /*
		   *get list of Items by Restaurant id and item category id 
		   */
		  @GetMapping("/item/categoryIdAndRestaurantId/{restId}/{catId}")
		  public ResponseEntity<List<Item>> findItemsCatIdAndRestId(@Valid @PathVariable("restId") Integer restId,@Valid @PathVariable("catId") String catId){
			  return new ResponseEntity<>(itemServ.findByRestIdAndCategoryId(restId, catId), HttpStatus.OK);
		  }
		  
		  /*
		   *get list of Items by Restaurant id in ascending order
		   */
		  @GetMapping("/item/restId/{restId}/sortByPriceAscending")
		  public ResponseEntity<List<Item>> getByRestIdAndSortedByPriceAscending(@Valid @PathVariable("restId") int restId){
			  return new ResponseEntity<>(itemServ.findByRestIdAndSortedByPriceAscending(restId), HttpStatus.OK);
		  }
		  
		  
		  /*
		   *get list of Items by Restaurant id in descending order
		   */
		  @GetMapping("/item/restId/{restId}/sortByPriceDescending")
		  public ResponseEntity<List<Item>> getByRestIdAndSortedByPriceDescending(@Valid @PathVariable("restId") int restId){
			  return new ResponseEntity<>(itemServ.findByRestIdAndSortedByPriceDescending(restId), HttpStatus.OK);
		  }
		  
		  /*
			 * This method will add item to cart and return foodcart
			 */
		@PostMapping("/item/cart/{cartId}")
			public ResponseEntity<FoodCart> addItemToCart(@PathVariable("cartId") String cartId,
					@Valid @RequestBody Item item) {
				return new ResponseEntity<>(itemServ.addItemToCart(cartId, item), HttpStatus.OK);
			}

		  
		  
		    
	}
