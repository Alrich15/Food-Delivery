package com.sprint.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sprint.entity.Item;
/*
 *Repository for Item to persist changes into database
 *
 */
public interface IItemDao extends JpaRepository<Item, String> {

	//Custom methods
	
	//Retrieve item details by given item name
	@Query("SELECT i FROM Item i"
			+ " WHERE i.itemName=:name ")
	Item viewItem(@Param("name")String itemName);
	
	
	//List all the available items in a specific cart sorted by their price(Ascending)
	@Query(value="SELECT i.* FROM item i,cart_items ci "
			+ "WHERE ci.item_id=i.item_id AND "
			+ "ci.cart_id=:cartid "
			+ "ORDER BY cost asc"
			, nativeQuery=true)
	List<Item> viewCartItemsByCostAsc(@Param("cartid")String cartId);
	
	//Search for an Item in given cart
	@Query(value="SELECT i.* FROM item i,cart_items ci "
			+ "WHERE i.item_id=ci.item_id AND "
			+ "ci.cart_id=:cid AND "
			+ "i.item_name=:iname"
			,nativeQuery=true)
	Item searchCartItem (@Param("cid") String cartId, @Param("iname") String itemName);
	
	//Search for all the items in cart by specific item category
	@Query(value="SELECT i.* FROM item i,cart_items ci,item_category ic "
			+ "WHERE ci.item_id=i.item_id AND "
			+ "i.itemcategory_id_fk=ic.item_category_id AND "
			+ "ic.item_category_name=:itemCategory AND "
			+ "ci.cart_id=:cartId"
			,nativeQuery=true)
	List<Item> searchCartItemByCateg(@Param("cartId")String cartId,@Param("itemCategory") String itemCategory);

	
	
	
	
	
	
	
	@Query(value = "select i.* from item i,restaurant_item ri where i.item_id= ri.item_id and ri.restaurant_id=:restId",nativeQuery=true)
	//@Query("select i from Item i,RestaurantItem ri where i.itemId= ri.itemId and ri.restaurantId=:restId")
	List<Item> findItemsByRestId(@Param("restId") Integer restId);
	
	//@Query(value = "select * from item where item_category_fk=:catId",nativeQuery=true)
	@Query("select i from Item i where item_category_fk=:catId")
	List<Item> findByItemCategoryId(@Param("catId") String catId);
	
	//@Query(value = "select * from item order by cost",nativeQuery=true)
	@Query("select i from Item i order by cost")
	List<Item> findAllItemsSortedByPrice();
	
	@Query(value = "select i.* from item i,restaurant_item ri where item_category_fk=:catId and i.item_id= ri.item_id and ri.restaurant_id=:restId",nativeQuery=true)
	List<Item> findByRestIdAndCategoryId(@Param("restId") Integer restId,@Param("catId") String catId);
	
	
	@Query(value = "select i.* from item i,restaurant_item ri where i.item_id= ri.item_id and ri.restaurant_id=:restId order by cost",nativeQuery=true)
	List<Item> findByRestIdAndSortedByPriceAscending(@Param("restId") Integer restId);
	
	@Query(value = "select i.* from item i,restaurant_item ri where i.item_id= ri.item_id and ri.restaurant_id=:restId order by cost desc",nativeQuery=true)
	List<Item> findByRestIdAndSortedByPriceDescending(@Param("restId") Integer restId);
	

	@Modifying
	@Transactional
	@Query(value="update item set qty=:quantity where item_id=:id",nativeQuery=true)
	void updateQuantity(@Param("quantity")int qty,@Param("id")String itemId);
	

}
	