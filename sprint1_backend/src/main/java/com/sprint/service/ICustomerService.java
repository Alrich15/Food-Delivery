package com.sprint.service;

import java.util.List;

import com.sprint.entity.Customer;

public interface ICustomerService {

	//Add Customer
	Customer addCustomer(Customer customer); 
	
	//Update Customer
	Customer updateCustomer(Customer customer); 
	
	//Delete Customer
	Customer deleteCustomerById(String customerId); 
	
	//View all Customers
	List<Customer> viewAllCustomers(); 
	
	//To view Customer by Id
	Customer viewCustomerById(String customerID); 
	
	//View Customer by First Name
	List<Customer> viewCustomerByFirstName(String firstName);
	
	//View Customer by above Age 
	List<Customer> viewCustomerByAgeAbove(int age);
	
	//View Customer by Area of Residence
	List<Customer> viewCustomerByArea(String area);
	
	//View Customer by City
	List<Customer> viewCustomerByCity(String city);

}
