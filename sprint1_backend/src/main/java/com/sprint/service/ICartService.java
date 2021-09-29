package com.sprint.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sprint.entity.FoodCart;
import com.sprint.entity.Item;

@Repository
public interface ICartService {

	
    //get all cart- Get
    public List<FoodCart> getAllCart();
    //View cart by id - Get
    FoodCart viewCart(String cartId);
 // Add item - Post
 	public FoodCart addItemToCart(String cartId, Item item);

 	FoodCart addCart(FoodCart cart);
    //Remove item from cart by cartId- Delete
     FoodCart deleteItemById(String cartId);
    //Remove cart - Delete
    void clearCart(FoodCart cart);
    
    
    

}
