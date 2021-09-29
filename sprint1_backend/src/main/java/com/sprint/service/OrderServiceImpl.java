package com.sprint.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.controller.OrderController;
import com.sprint.dao.IOrderDao;
import com.sprint.entity.OrderDetails;
import com.sprint.exception.OrderAlreadyExistException;
import com.sprint.exception.OrderNotFoundException;
import org.apache.logging.log4j.Logger;

/*
 * Service to mark the class as a service provider.
 */
@Service
public class OrderServiceImpl implements IOrderService{

	
	@Autowired //used to inject the object dependency implicitly
	IOrderDao orderRepository;

	/*
	 * Service Method implementation to add order where it returns OrderDetails passing order
	 */
	@Override
	public OrderDetails addOrder(OrderDetails order) {
		Optional<OrderDetails> opt = orderRepository.findById(order.getOrderId()); //Optional is a container object used to contain not-null objects
		if(opt.isPresent()) {
			/*
			 * throws an exception when order with the given id is already there in the database 
			 */
			throw new OrderAlreadyExistException("Order already exists with given id: "+order.getOrderId());
		}
		
		
		/*
		 * saves the order details by calling save method from JPA repository
		 */
		return orderRepository.save(order);
	}

	
	/*
	 * Service Method Implementation to Update Order where it returns OrderDetails passing order
	 */
	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		Optional<OrderDetails> opt = orderRepository.findOrderById(order.getOrderId()); //Optional is a container object used to contain not-null objects
		if(!opt.isPresent()) {
			/*
			 * throws an exception if order is not found 
			 */
			throw new OrderNotFoundException("Unable to update because order details does not exist for given id: "+order.getOrderId());
		}
		if(opt.isPresent()) { 
			OrderDetails orderdb = opt.get();
			orderdb.setOrderDate(order.getOrderDate());
			orderdb.setOrderStatus(order.getOrderStatus());
			orderRepository.save(orderdb);
		}
		
		return order;
	}


	/*
	 * Service Method Implementation to view Order details 
	 */
	@Override
	public List<OrderDetails> viewOrder() {
		
		/*
		 * calls the method findAll which is provided by JPA Repository and returns OrderStatus based on order id
		 */
		return orderRepository.findAll(); 
	}
	

	/*
	 * Service Method Implementation to get Order Details based on id
	 */
	@Override
	public OrderDetails viewOrderById(String orderId) {
		
		Optional<OrderDetails> opt = orderRepository.findOrderById(orderId); //Optional is a container object used to contain not-null objects
		if(!opt.isPresent()) {
			throw new OrderNotFoundException("Order details does not exist for given id: "+orderId);
		}
		
		return opt.get();
	}

	
	/*
	 * Service Method Implementation to remove Order Details based on id
	 */
	@Override
	public OrderDetails removeOrderById(String orderId) {
		Optional<OrderDetails> opt = orderRepository.findById(orderId);//Optional is a container object used to contain not-null objects
		if(opt.isPresent()) {
			orderRepository.delete(opt.get());
			return opt.get();
		}
		
		return null;
	}

	
	/*
	 * Service Method Implementation to update Order status based on id
	 */
	@Override
	public OrderDetails updateOrderStatus(String orderId, String orderStatus) {
		
		Optional<OrderDetails> opt = orderRepository.findById(orderId); //Optional is a container object used to contain not-null objects
		if(!opt.isPresent()) {
			/*
			 * throws an exception if order is not found 
			 */
			throw new OrderNotFoundException("Unable to update order status because order details does not exist for given id: "+orderId);
		}
		OrderDetails orderdb = opt.get();
		if(opt.isPresent()) {
			orderdb.setOrderStatus(orderStatus);
			orderRepository.save(orderdb);
		}
		
		return orderdb;
	}

	
	/*
	 * Service Method Implementation to get Order Details based on order date
	 */
	@Override
	public List<OrderDetails> viewOrderByDate(LocalDate orderDate) {
		Optional<List<OrderDetails>> opt = Optional.of(orderRepository.findOrderByDate(orderDate)); //Optional is a container object used to contain not-null objects
		if(!opt.isPresent()) {
			/*
			 * throws an exception if order is not found 
			 */
			throw new OrderNotFoundException("Order Details does not exist for given order date:"+orderDate);
		}
		
		return orderRepository.findOrderByDate(orderDate);
	}
	

	/*
	 * Service Method Implementation to get Order Status based on id
	 */
	@Override
	public String viewOrderStatusById(String orderId) {
		Optional<OrderDetails> opt = orderRepository.findById(orderId);  //Optional is a container object used to contain not-null objects
		if(!opt.isPresent()) {
			/*
			 * throws an exception if order is not found 
			 */
			throw new OrderNotFoundException("Order status does not exist for given id: "+orderId);
		}
		
		/*
		 * calls the method from IOrderDao class which is provided by JPA Repository and returns OrderStatus based on order id
		 */
		return orderRepository.viewOrderStatus(orderId);
	}


	/*
	 * Service Method Implementation to get Order Details based on food cart id
	 */
	@Override
	public OrderDetails viewAllOrdersByCartId(String cartId) {
		
		/*
		 * calls the custom query method from IOrderDao class and returns OrderDetails based on food cart id
		 */
		return orderRepository.getOrderByCartId(cartId);
	}


	
	
	
//	/*
//	 * Service Method Implementation to get all Orders Details based on Restaurant id
//	 */
//	@Override
//	public List<OrderDetails> viewAllOrdersByRestaurantId(Integer restaurantId) {
//		return orderRepository.getOrderByRestaurantId(restaurantId);
//
//	}
//
//	
//	/*
//	 * Service Method Implementation to get all Order Details  based on Restaurant id
//	 */
//	@Override
//	public List<OrderDetails> viewAllOrdersByRestaurantIdSortedByDate(Integer restaurantId) {
//		return orderRepository.getOrderByRestaurantIdAndSortByDate(restaurantId);
//
//	}


	


	
	

}
