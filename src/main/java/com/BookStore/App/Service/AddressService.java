package com.BookStore.App.Service;

import com.BookStore.App.Model.Address;

import java.util.*;


public interface AddressService {
	
	List<Address> getAddresses();
	
	Address getAddressById(int id);
	
	Address addAddress(Address address);
	
	Address updateAddress(int id, Address address);
	
	void deleteAddress(int id);
}
