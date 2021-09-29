package com.sprint.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint.entity.FoodCart;
import com.sprint.entity.Item;
	
@Repository
public interface ICartDao extends JpaRepository<FoodCart, String> {

	@Query(value = "SELECT i.* FROM Item i, cart_items ci WHERE i.item_id=ci.item_id", nativeQuery = true)
	Item findItemById(@Param("item_id") String itemId);
	
	Optional<FoodCart> findByCartId(String cartId);
}
