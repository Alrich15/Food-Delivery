package com.sprint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dao.ICartDao;
import com.sprint.entity.FoodCart;
import com.sprint.entity.Item;
import com.sprint.exception.FoodCartAlreadyExistsException;
import com.sprint.exception.FoodCartNotFoundException;

@Service
public class ICartServiceImpl implements ICartService {

	@Autowired
	ICartDao cartDao;
	
	


	// clear cart
	@Override
	public void clearCart(FoodCart cart) {
		
		 cartDao.deleteAll();
	}


	// remove item by id
		/*
		 * This method will accept cart id and if id is present then method will delete
		 * cart
		 */	@Override
	public FoodCart deleteItemById(String cartId) {
		Optional<FoodCart> opt = cartDao.findById(cartId);
		if(opt.isPresent()) {
			cartDao.delete(opt.get());
		}
		else {
			throw new FoodCartNotFoundException("Food cart not found with given id:"+cartId);
		}
		return opt.get();
		
	}
		 /*
			 * this method will find all the carts present
			 */
 @Override
	public List<FoodCart> getAllCart() {
		return (List<FoodCart>) cartDao.findAll();
	}

	public FoodCart viewCart(String cartId) {
		Optional<FoodCart> opt = cartDao.findById(cartId);
		if(!opt.isPresent()) {
		  throw new FoodCartNotFoundException("Food cart not found with given id:"+cartId);
		}
		return opt.get();
	}

	 /*
		 * This method will add item to cart and return foodcart
		 */
	@Override
	public FoodCart addItemToCart(String cartId, Item item) {
		Optional<FoodCart> opt = cartDao.findByCartId(cartId);
		if (opt.isPresent()) {
			FoodCart cart = opt.get();
			cart.getCartItems().add(item);
			cart.setTotalAmount(cart.getTotalAmount() + (item.getQty() * item.getCost()));
			return cartDao.save(cart);
		} else {
			throw new FoodCartNotFoundException("Food cart not found with given id:" + cartId);
		}

	}


	@Override
	public FoodCart addCart(FoodCart cart) {
		// TODO Auto-generated method stub
		return null;
	}
}
