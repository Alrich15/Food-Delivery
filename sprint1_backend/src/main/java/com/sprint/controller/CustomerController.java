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

import com.sprint.entity.Customer;
//import com.cg.mts.entities.Customer;
//import com.cg.mts.service.ICustomerService;
import com.sprint.service.*;

@CrossOrigin
@RestController
public class CustomerController {
	
	@Autowired
	ICustomerService customerServ; 

	//View all customers
	@GetMapping("/customer/all")
	public List<Customer> getAllCustomers()	{
		return customerServ.viewAllCustomers();
	}
	
	//Add customer
	@PostMapping("/customer")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return customerServ.addCustomer(customer);
	}
	
	//Update customer
	@PutMapping("/customer/update")
	public Customer updateCustomer(@Valid @RequestBody Customer customer) {
		return customerServ.updateCustomer(customer);
	}
	
	//View customer by Id
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> viewCustomerById(@PathVariable("customerId")String customerId) {
		return new ResponseEntity<>(customerServ.viewCustomerById(customerId), HttpStatus.OK);
	}
	
	//Delete customer by Id
	@DeleteMapping("/delete/{customerId}")
	public Customer deleteCustById(@PathVariable("customerId")String customerId) {
		return customerServ.deleteCustomerById(customerId);
	}
	
	//Get customer by area
	@GetMapping("/customer/byArea/{area}")
	public List<Customer> viewCustomerByArea(@PathVariable("area") String area){
		return customerServ.viewCustomerByArea(area);
	}
	
	@GetMapping("/customer/byCity/{city}")
	public List<Customer> viewCustomerByCity(@PathVariable("city") String city){
		return customerServ.viewCustomerByCity(city);
	}
	
	@GetMapping("/customer/byName/{firstName}")
	public List<Customer> viewCustomerByFirstName(@PathVariable("firstName") String firstName) {
		return customerServ.viewCustomerByFirstName(firstName);
	}
	
	@GetMapping("/customer/byAge/Above/{age}")
	public List<Customer> viewCustomerByAgeAbove(@PathVariable("age") int age) {
		return customerServ.viewCustomerByAgeAbove(age);
	}
	
}
