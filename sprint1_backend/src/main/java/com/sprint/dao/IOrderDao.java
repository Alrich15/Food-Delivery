package com.sprint.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sprint.entity.OrderDetails;

/*
 * Repository annotation provides the mechanism for CRUD (Create,Remove,Update and Delete) Operations
 */
@Repository
public interface IOrderDao extends JpaRepository<OrderDetails,String> {
	
	/*
	 * Custom query to return OrderStatus from OrderDetails table based on order id
	 */
	@Query("select o.orderStatus from OrderDetails o where o.orderId=:Id")  //Custom Query to return orderStatus by id
	
	String viewOrderStatus(@Param("Id") String orderId);  //Custom Method to return orderStatus by id
	
	
	/*
	 * Custom query to display OrderDetails from OrderDetails Table based on date
	 */
	@Query("select o from OrderDetails o where o.orderDate=:date")   //Custom Query to display orderDetails based on order date
	
	List<OrderDetails> findOrderByDate(@Param("date") LocalDate orderDate);  //Custom Method to return orderDetails based on order date
	
	
	/*
	 * Custom query to display OrderDetails from OrderDetails table based on order id 
	 */
	@Query("select o from OrderDetails o where o.orderId=:id")   //Custom Query to return OrderDetails based on order id 
	
	Optional<OrderDetails> findOrderById(@Param("id") String orderId);    //Custom method to return OrderDetails based on order id 
	

	/*
	 * Custom query to display OrderDetails  from OrderDetails table based on food cart id.
	 */
	@Query(value="select * from orderdetails where cart_id_fk=:cartId",nativeQuery=true) //Custom Query to return OrderDetails based on foodCart id 
	
	OrderDetails getOrderByCartId(@Param("cartId") String cartId); //Custom method to return OrderDetails based on foodCart id 
	
	

//	/*
//	 * Custom query to display OrderDetails from OrderDetails table based on restaurant id which is a foreign key from restaurant table
//	 */
//	@Query(value="select * from orderDetails where restaurant_restaurant_id=:restId",nativeQuery=true)
//	List<OrderDetails> getOrderByRestaurantId(@Param("restId") Integer restaurantId);  //Custom Method to return OrderDetails based on restaurant id
//	
//	
//	/*
//	 * Custom query to display OrderDetails based on date ordered from OrderDetails table based on restaurant id.
//	 */
//	@Query(value="select * from orderDetails where restaurant_restaurant_id=:restId order by order_date",nativeQuery=true) //Custom Query to return OrderDetails based on restaurant id
//	List<OrderDetails> getOrderByRestaurantIdAndSortByDate(@Param("restId") Integer restaurantId); //Custom Method to return OrderDetails based on restaurant id
	


	
	
	

}
