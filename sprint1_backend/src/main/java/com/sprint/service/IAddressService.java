package com.sprint.service;

import java.util.List;

import com.sprint.entity.Address;

public interface IAddressService {
	
	//Getting all Addresses
	//GET
	List<Address> getAllAddress();
	
	
	//Get Addresses based on Id
	//GET
	Address getAddrById(String addressId);
	
	
	//Get Addresses by Area
	//GET
	//Address getAddrByArea(String area);
	List<Address> getAddrByArea(String area);
	
	
	//Add new Address
	//POST
	Address addAddress(Address address);
	
	
	//Delete Address based on Id
	//DELETE
	Address deleteAddrById(String addressId);
	
	
	// Update Address
	//PATCH
	Address updateAddress(Address address);
	
}
