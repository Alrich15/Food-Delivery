package com.sprint.service;

import java.time.LocalDate;
import java.util.List;
import com.sprint.entity.OrderDetails;

public interface IOrderService {
	
	    /*
	     * Method to add order details 
	     */
		public OrderDetails addOrder(OrderDetails order);
		
		
		/*
		 * Method to update the order details
		 */
		public OrderDetails updateOrder(OrderDetails order);
		
		
		/*
		 * Method to remove a particular order by given id
		 */
		public OrderDetails removeOrderById(String orderId);
		
		
		/*
		 * Method to view the list of all orders
		 */
		public List<OrderDetails> viewOrder();
		
		
		/*
		 * Method to view list of all orders based on food cart Id 
		 */
		public OrderDetails viewAllOrdersByCartId(String cartId);
		
		
		
		
		/*
		 * Method to view a particular order by given id
		 */
		public OrderDetails viewOrderById(String orderId);
		
		
		/*
		 * Method to view a particular order status by given id
		 */
		public String viewOrderStatusById(String orderId);
		
		
		/*
		 * Method to view a particular order by given date
		 */
		public List<OrderDetails> viewOrderByDate(LocalDate orderDate);
		
		
		/*
		 * Method to update status of the order based on id and passing updated order status
		 */
		public OrderDetails updateOrderStatus(String orderId,String orderStatus);
		
//		/*
//		 * Method to view list of all orders by Restaurant Id
//		 */
//		public List<OrderDetails> viewAllOrdersByRestaurantId(Integer restaurantId);
//		
//		
//		/*
//		 * Method to view list of all order by Restaurant Id sorted by date of order
//		 */
//		public List<OrderDetails> viewAllOrdersByRestaurantIdSortedByDate(Integer restaurantId);
		

}
