package com.BookStore.App.Controller;

import com.BookStore.App.Controller.POJO.AddressRequest;
import com.BookStore.App.Controller.POJO.AddressResponse;
import com.BookStore.App.Controller.POJO.GetAddressResponse;
import com.BookStore.App.Model.Address;
import com.BookStore.App.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookStore/api/address")
public class AddressController {
    
    @Autowired
    private AddressService addressService;
 
 
    // Get all addresses  
    @GetMapping
    public ResponseEntity<GetAddressResponse> getAddresses() {
        List<Address> addresses = addressService.getAddresses();
        List<AddressResponse> addressResponseList = addresses.stream()
        		.map(address -> new AddressResponse(address.getId(),address.getLine1(),address.getLine2(),address.getCity(),address.getPincode(),address.getMobileNo()))
        		.collect(Collectors.toList());
        
        return new ResponseEntity<>(new GetAddressResponse(addressResponseList), HttpStatus.OK);
    }

    // Get address by ID  
    @GetMapping("/{id}")
    public ResponseEntity<GetAddressResponse> getAddress(@PathVariable int id) {
        Address address = addressService.getAddressById(id);
        AddressResponse addressResponse = new AddressResponse(address.getId(),address.getLine1(),address.getLine2(),address.getCity(),address.getPincode(),address.getMobileNo());
        List<AddressResponse> addressResponseList = Collections.singletonList(addressResponse);
        return new ResponseEntity<>(new GetAddressResponse(addressResponseList), HttpStatus.OK);
    }

    // Add new address 
    @PostMapping
    public ResponseEntity<GetAddressResponse> addAddress(@RequestBody AddressRequest addressRequest) {
    	Address address = new Address(
    			addressRequest.getLine1(),
    			addressRequest.getLine2(),
    			addressRequest.getCity(),
    			addressRequest.getPincode(),
    			addressRequest.getMobileNo());
    	
        Address newAddress = addressService.addAddress(address);
        
        AddressResponse addressResponse = new AddressResponse(
        		newAddress.getId(),
        		newAddress.getLine1(),
        		newAddress.getLine2(),
        		newAddress.getCity(),
        		newAddress.getPincode(),
        		newAddress.getMobileNo());
        
        List<AddressResponse> addressResponseList = Collections.singletonList(addressResponse);
        return new ResponseEntity<>(new GetAddressResponse(addressResponseList), HttpStatus.CREATED);
    
    }

    // Update address by ID  
    @PutMapping("/{id}")
    public ResponseEntity<GetAddressResponse> updateAddress(@PathVariable int id, @RequestBody AddressRequest addressRequest) {
    	Address address = new Address(
    			addressRequest.getLine1(),
    			addressRequest.getLine2(),
    			addressRequest.getCity(),
    			addressRequest.getPincode(),
    			addressRequest.getMobileNo());
    	
        Address newAddress = addressService.updateAddress(id, address);

        AddressResponse addressResponse = new AddressResponse(
        		newAddress.getId(),
        		newAddress.getLine1(),
        		newAddress.getLine2(),
        		newAddress.getCity(),
        		newAddress.getPincode(),
        		newAddress.getMobileNo());
        
        List<AddressResponse> addressResponseList = Collections.singletonList(addressResponse);
        return new ResponseEntity<>(new GetAddressResponse(addressResponseList), HttpStatus.CREATED);
     }

    // Delete address by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>("Address deleted successfully", HttpStatus.NO_CONTENT);
    }

}
