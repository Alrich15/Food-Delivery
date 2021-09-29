package com.sprint.controller;


import java.time.LocalDate;

import java.util.List;


import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.Logger;
import com.sprint.entity.OrderDetails;
import com.sprint.service.IOrderService;

/*
 RestController annotation is combination of controller and ResponseBody annotation
 */
@CrossOrigin
@RestController
@Validated
public class OrderController {
	
	private static final Logger Logger = LogManager.getLogger(OrderController.class);
	/*
	 *AutoWired annotation is used to inject the object dependency implicitly
	 */
	@Autowired //used to inject the object dependency implicitly
	IOrderService orderService;
	
	/*
	 * PostMapping annotated methods handle the HTTP POST requests matched with given URI expression.
	 */
	@PostMapping("/orderdetails/add") //Add the details 
	public ResponseEntity<OrderDetails> addOrder(@Valid @RequestBody  OrderDetails order) {
		Logger.info("OrderDetails added for given id: " +order.getOrderId());
		
		//Returns suitable response with appropriate HTTP status code
		return new ResponseEntity<>(orderService.addOrder(order),HttpStatus.ACCEPTED); //202 Accepted
	}
	
	/*
	 * Put Mapping annotation for mapping HTTP PUT requests onto specific handler methods
	 */
	@PutMapping("/orderdetails") //updates the details 
	public ResponseEntity<OrderDetails> updateOrder(@Valid @RequestBody OrderDetails order) {
		Logger.info("OrderDetails updated of given id: " +order.getOrderId());
		
		//Returns suitable response with appropriate HTTP status code
		return new ResponseEntity<>(orderService.updateOrder(order),HttpStatus.ACCEPTED); //202 Accepted
	}
	
	/*
	 * GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
	 */
	@GetMapping("/orderdetails/all")  
	public ResponseEntity<List<OrderDetails>> viewOrder() {
		Logger.info("OrderDetails found ");
		
		//Returns suitable response with appropriate HTTP status code
		return new ResponseEntity<> (orderService.viewOrder(),HttpStatus.OK); //200 OK
	}
	
	/*
	 * GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
	 */
	@GetMapping("/orderdetails/byId/{id}") //fetch the details based on id provided
	public ResponseEntity<OrderDetails> viewOrderDetailsById(@PathVariable(value="id") String orderId) {
		Logger.info("OrderDetails found of id: " +orderId);
		
		//Returns suitable response with appropriate HTTP status code
		return new ResponseEntity<>(orderService.viewOrderById(orderId),HttpStatus.OK);//200 OK
	}
	
	/*
	 * GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
	 */
	@GetMapping("/orderdetails/status/{id}") //fetch the details based on id provided
	public ResponseEntity<String> viewOrderStatusById(@PathVariable(value="id") String orderId) {
		Logger.info("OrderStatus updated of id: " +orderId);
		
		//Returns suitable response with appropriate HTTP status code
		return new ResponseEntity<>(orderService.viewOrderStatusById(orderId),HttpStatus.OK); //200 OK
	}

	/*
	 * GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
	 */
	@GetMapping("/orderdetails/byDate/{date}") 
	public ResponseEntity<List<OrderDetails>> viewOrderDetailsByDate(@PathVariable(value="date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate orderDate) {
		Logger.info("OrderDetails found with give date: "+orderDate);
		
		//Returns suitable response with appropriate HTTP status code
		return new ResponseEntity<>(orderService.viewOrderByDate(orderDate),HttpStatus.OK); //200 OK
	}
	
	/*
	 * DeleteMapping annotated methods handle the HTTP DELETE requests matched with given URI expression.
	 */
	@DeleteMapping("/orderdetails/delete/byId/{id}") //delete the details based on id provided
	public OrderDetails removeOrderById(@PathVariable(value="id") String orderId) {
		Logger.info("OrderDetails removed of id: " +orderId);
		return orderService.removeOrderById(orderId);
	}
	
	/*
	 * PatchMapping annotated methods handle the HTTP PATCH(Update) requests matched with given URI expression.
	 */
	@PatchMapping("/orderdetails/update/status/{id}") 
	public ResponseEntity<OrderDetails> updateOrderStatus(@PathVariable(value="id")String orderId, @RequestBody String orderStatus) {
		Logger.info("OrderStatus updated of id: " +orderId);
		
		//Returns suitable response with appropriate HTTP status code
		return new ResponseEntity<>( orderService.updateOrderStatus(orderId, orderStatus),HttpStatus.ACCEPTED); //202 Accepted
	}
	
	/*
	 * GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
	 */
	@GetMapping("/orderdetails/cartId/{cartId}")
	public ResponseEntity<OrderDetails> viewAllOrdersByCartId(@PathVariable("cartId") String cartId) {
		//Returns suitable response with appropriate HTTP status code
		return new ResponseEntity<>(orderService.viewAllOrdersByCartId(cartId),HttpStatus.OK); //200 OK
		
	}
	

	


}
