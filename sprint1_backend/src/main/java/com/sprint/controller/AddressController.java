package com.sprint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.entity.Address;
import com.sprint.service.AddressServiceImpl;

@CrossOrigin
@RestController
public class AddressController {
	@Autowired
	AddressServiceImpl adServ;
	
	//Getting all addresses
	//This method will display all the addresses in the database
	@GetMapping("/address/all")
	public List<Address> getAllAddress(){
		return adServ.getAllAddress();
	}


	//Get Addresses using Id
	//Using this, we can get particular address from address table from database using addressId
	@GetMapping("/address/{addressId}")
	public Address getAddrById(@Valid @PathVariable("addressId") String addressId) {
		return adServ.getAddrById(addressId);
	}


	//Get Address using Area
	//Using this, we can get the list of addresses of same ares which are stored in database
	@GetMapping("/address/byArea/{area}")
	/*public ResponseEntity<Address> getAddrByArea(@PathVariable("area") String area) {
		return new ResponseEntity<>(adServ.getAddrByArea(area),HttpStatus.OK);
	}*/
	public List<Address> getAddrByArea(@Valid @PathVariable("area") String area){
		return adServ.getAddrByArea(area);
	}

	
	//Add new Address
	//To add new address in database
	@PostMapping("/address")
	public Address addAddress(@Valid @RequestBody Address address) {
		return adServ.addAddress(address);
	}

	
	//Delete Address by Id
	//To remove address from database using addressId
	@DeleteMapping("/address/delete/Id/{addressId}")
	public Address deleteAddrById(@PathVariable("addressId") String addressId) {
		return adServ.deleteAddrById(addressId);
	}


	// Update Address
	//To update the previous address in database
	@PatchMapping("/address")
	public Address updateAddress(@Valid @RequestBody Address address) {
		return adServ.updateAddress(address);
	}
}
