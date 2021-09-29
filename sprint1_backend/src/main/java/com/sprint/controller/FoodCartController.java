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

import com.sprint.entity.FoodCart;
import com.sprint.entity.Item;
import com.sprint.service.ICartServiceImpl;


@CrossOrigin
@RestController
public class FoodCartController {
	
	@Autowired
	ICartServiceImpl cartServ;
	
	//get item
	@GetMapping("/foodcart/all")
	public List<FoodCart> getCart(){
		return cartServ.getAllCart();
	}
	
	@PostMapping("/foodcart/add")
	public FoodCart addItemToCart(@Valid @PathVariable("id") String cartId,@RequestBody Item item) {
		return cartServ.addItemToCart(cartId,item);
	}
	
	
	@GetMapping("/foodcart/view/{id}")
	public FoodCart viewCart(@PathVariable("id") String cartId) {
		return cartServ.viewCart(cartId);
	}
	
	//remove item by id - delete mapping
	@DeleteMapping("/foodcart/remove/{id}")
	public ResponseEntity<FoodCart> deleteItemById(@PathVariable("id") String cartId) {
		return new ResponseEntity<>(cartServ.deleteItemById(cartId),HttpStatus.OK);
	}
	
	
	
	// clear cart - delete mapping
	@DeleteMapping("/foodcart/delete")
    public void clearCart(FoodCart cart) {
	   cartServ.clearCart(cart)	;
	}
	
//	@PostMapping("/foodcart/add")
//	public FoodCart addCart(@Valid @RequestBody FoodCart cart) {
//		
//		return cartServ.addCart(cart);
//	}

	
	
}
