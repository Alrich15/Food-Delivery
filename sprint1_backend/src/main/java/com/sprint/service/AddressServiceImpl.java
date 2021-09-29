package com.sprint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.sprint.dao.IAddressDao;
import com.sprint.entity.Address;
import com.sprint.exception.AddressAlreadyExistException;
import com.sprint.exception.AddressNotFoundException;

@Service
public class AddressServiceImpl implements IAddressService{
	
	@Autowired
	IAddressDao adDao;

	@Override
	//Get all addresses in database
	public List<Address> getAllAddress() {
		return adDao.findAll();
	}
	
	//Get all addresses using id
	@Override
	public Address getAddrById(String addressId) {
		Optional<Address> opt = adDao.findById(addressId);
		//id any entry of that id is not present
		//then it will throw exception
		if(!opt.isPresent()) {
			throw new AddressNotFoundException("Address not found for given id: " + addressId);
		}
		return opt.get();
	}
	
	//Get list of addresses using area 
	@Override
	public List<Address> getAddrByArea(String area) {
		return adDao.getAddrByArea(area);
	}
	
	//To add new address in database
	@Override
	public Address addAddress(Address address) {
		//If address with same parameters is already present
		//then it will throw exception
		Optional<Address> opt = adDao.findById(address.getAddressId());
		if(opt.isPresent()) {
			throw new AddressAlreadyExistException("Address already exist for given id: " + address.getAddressId());
		}
		return adDao.save(address);
	}
	
	//Delete the existing address using id
	@Override
	public Address deleteAddrById(String addressId) {
		//If no address with given id is present in database
		//the it will throw exception
		Optional<Address> opt = adDao.findById(addressId);
		if(!opt.isPresent()) {
			throw new AddressNotFoundException("Address not found for given id: " + addressId);
		}
		adDao.deleteById(addressId);
		return opt.get();
	}
	
	//Update the existing address
	@Override
	public Address updateAddress(Address address) {
		// Find address
		Optional<Address> opt = adDao.findById(address.getAddressId());
		// Update address details if present
		if (opt.isPresent()) {
			Address dbAddr = opt.get();
			dbAddr.setBuildingName(address.getBuildingName());
			dbAddr.setStreetNo(address.getStreetNo());
			dbAddr.setArea(address.getArea());
			dbAddr.setCity(address.getCity());
			dbAddr.setState(address.getState());
			dbAddr.setCountry(address.getCountry());
			dbAddr.setPincode(address.getPincode());
			//dbAddr.setRestaurant(address.getRestaurant());
			// save
			adDao.save(dbAddr);
		}
		//If address details are not present then
		//throw exception
		else {
			throw new AddressNotFoundException("Address not found for given id: " + address.getAddressId());
		}
		return address;
		
	}

}
