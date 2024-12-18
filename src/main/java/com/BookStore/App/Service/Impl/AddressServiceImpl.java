package com.BookStore.App.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStore.App.Model.Address;
import com.BookStore.App.Repository.AddressRepository;
import com.BookStore.App.Service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<Address> getAddresses() {
		return addressRepository.findAll();
	}

	@Override
	public Address getAddressById(int id) { 
		Optional<Address> address = addressRepository.findById(id);
		
		Address newAddress = address.get();
		return newAddress;
		
	}

	@Override
	public Address addAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address updateAddress(int id, Address address) {
		
		Address newAddress= addressRepository.findById(id).orElse(null);
		
		newAddress.setCity(address.getCity());
		newAddress.setLine1(address.getLine1());
		newAddress.setLine2(address.getLine2());
		newAddress.setCity(address.getCity());
		newAddress.setPincode(address.getPincode());
		newAddress.setMobileNo(address.getMobileNo());
		
		return addressRepository.save(newAddress);
	}

	@Override
	public void deleteAddress(int id) {
		 addressRepository.deleteById(id);
	}
	
	
}
