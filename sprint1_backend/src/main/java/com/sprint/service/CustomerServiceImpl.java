package com.sprint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sprint.entity.Customer;
import com.sprint.exception.CustomerAlreadyExistException;
import com.sprint.exception.CustomerNotFoundException;
import com.sprint.dao.ICustomerDao;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	ICustomerDao customerDao;

	@Override
	public Customer addCustomer(Customer customer) {
		Optional<Customer> opt = customerDao.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			throw new CustomerAlreadyExistException("Customer already exist for given id: " + customer.getCustomerId());
		}
		return customerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		//Find Customer
		Optional<Customer> opt = customerDao.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			
			//update customer details
			Customer cust = opt.get();
			cust.setFirstName(customer.getFirstName());
			cust.setLastName(customer.getLastName());
			cust.setAge(customer.getAge());
			cust.setGender(customer.getGender());
			cust.setMobileNumber(customer.getMobileNumber());
			cust.setEmail(customer.getEmail());
//			cust.setAddress(customer.getAddress());
			
			//Save customer
			customerDao.save(cust);
		}
		//throw exception
		else {
			throw new CustomerNotFoundException("No customer found with given Id: "+ customer.getCustomerId());
		}
		return customer;
	}

	@Override
	public Customer deleteCustomerById(String customerId) {
		//Find customer
		Optional<Customer> opt = customerDao.findById(customerId);
		if(!opt.isPresent()) {
			throw new CustomerNotFoundException("No customer found with given Id: "+ customerId);
		}
		customerDao.deleteById(customerId);
		return opt.get();
	}

	@Override
	public List<Customer> viewAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public Customer viewCustomerById(String customerId) {
		Optional<Customer> opt = customerDao.findById(customerId);
		if(!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given Id: "+customerId);
		}
		return opt.get();	
	}

	@Override
	public List<Customer> viewCustomerByArea(String area) {
		return customerDao.viewCustomerByArea(area);
	}

	@Override
	public List<Customer> viewCustomerByCity(String city) {
		return customerDao.viewCustomerByCity(city);
	}

	@Override
	public List<Customer> viewCustomerByFirstName(String firstName) {
		return customerDao.viewCustomerByFirstName(firstName);
	}

	@Override
	public List<Customer> viewCustomerByAgeAbove(int age) {
		return customerDao.viewCustomerByAgeAbove(age);
	}
	
}
	