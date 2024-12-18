package com.BookStore.App.Controller;

import com.BookStore.App.Controller.POJO.AddressRequest;
import com.BookStore.App.Controller.POJO.AddressResponse;
import com.BookStore.App.Model.Address;
import com.BookStore.App.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookStore/api/address")
public class AddressController {
    
    @Autowired
    private AddressService addressService;

    // Convert AddressRequest to Address (for create/update)
    private Address convertToAddress(AddressRequest addressRequest) {
        Address address = new Address();
        address.setLine1(addressRequest.getLine1());
        address.setLine2(addressRequest.getLine2());
        address.setCity(addressRequest.getCity());
        address.setPincode(addressRequest.getPincode());
        address.setMobileNo(addressRequest.getMobileNo());
        return address;
    }

    // Convert Address to AddressResponse (for response with ID)
    private AddressResponse convertToAddressResponse(Address address) {
        return new AddressResponse(
            address.getId(),
            address.getLine1(),
            address.getLine2(),
            address.getCity(),
            address.getPincode(),
            address.getMobileNo()
        );
    }

    // Get all addresses (returns a list of AddressResponse directly)
    @GetMapping("/getAll")
    public ResponseEntity<List<AddressResponse>> getAddresses() {
        List<Address> addresses = addressService.getAddresses();
        List<AddressResponse> addressResponses = new ArrayList<>();
        for (Address address : addresses) {
            addressResponses.add(convertToAddressResponse(address));
        }
        return new ResponseEntity<>(addressResponses, HttpStatus.OK);
    }

    // Get address by ID (returns a single AddressResponse)
    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddress(@PathVariable int id) {
        Address address = addressService.getAddressById(id);
        if (address != null) {
            AddressResponse addressResponse = convertToAddressResponse(address);
            return new ResponseEntity<>(addressResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Add new address (accepts AddressRequest for creation)
    @PostMapping("/add")
    public ResponseEntity<String> addAddress(@RequestBody AddressRequest addressRequest) {
        Address address = convertToAddress(addressRequest);
        addressService.addAddress(address);
        return new ResponseEntity<>("Address added successfully", HttpStatus.CREATED);
    }

    // Update address by ID (accepts AddressRequest for updating)
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable int id, @RequestBody AddressRequest addressRequest) {
        Address address = convertToAddress(addressRequest);
        addressService.updateAddress(id, address);
        return new ResponseEntity<>("Address updated successfully", HttpStatus.OK);
    }

    // Delete address by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>("Address deleted successfully", HttpStatus.NO_CONTENT);
    }

}




//package com.BookStore.App.Controller;
//
//import com.BookStore.App.Controller.POJO.AddressRequest;
//import com.BookStore.App.Controller.POJO.AddressResponse;
//import com.BookStore.App.Controller.POJO.GetAddressResponse;
//import com.BookStore.App.Model.Address;
//import com.BookStore.App.Service.AddressService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/bookStore/api/address")
//public class AddressController {
//    
//    @Autowired
//    private AddressService addressService;
//
//    // Convert AddressRequest to Address (for create/update)
//    private Address convertToAddress(AddressRequest addressRequest) {
//        Address address = new Address();
//        address.setLine1(addressRequest.getLine1());
//        address.setLine2(addressRequest.getLine2());
//        address.setCity(addressRequest.getCity());
//        address.setPincode(addressRequest.getPincode());
//        address.setMobileNo(addressRequest.getMobileNo());
//        return address;
//    }
//
//    // Convert Address to AddressResponse (for response with ID)
//    private AddressResponse convertToAddressResponse(Address address) {
//        return new AddressResponse(
//            address.getId(),
//            address.getLine1(),
//            address.getLine2(),
//            address.getCity(),
//            address.getPincode(),
//            address.getMobileNo()
//        );
//    }
//
//    // Convert List<Address> to GetAddressResponse (for response with list of addresses)
//    private GetAddressResponse convertToGetAddressResponse(List<Address> addresses) {
//        List<AddressResponse> addressResponses = new ArrayList<>();
//        for (Address address : addresses) {
//            addressResponses.add(convertToAddressResponse(address));
//        }
//        return new GetAddressResponse(addressResponses);
//    }
//
//    // Get all addresses (returns a list wrapped in GetAddressResponse)
//    @GetMapping("/getAll")
//    public ResponseEntity<GetAddressResponse> getAddresses() {
//        List<Address> addresses = addressService.getAddresses();
//        GetAddressResponse response = convertToGetAddressResponse(addresses);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    // Get address by ID (returns a single AddressResponse)
//    @GetMapping("/{id}")
//    public ResponseEntity<AddressResponse> getAddress(@PathVariable int id) {
//        Address address = addressService.getAddressById(id);
//        if (address != null) {
//            AddressResponse addressResponse = convertToAddressResponse(address);
//            return new ResponseEntity<>(addressResponse, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    // Add new address (accepts AddressRequest for creation)
//    @PostMapping("/add")
//    public ResponseEntity<String> addAddress(@RequestBody AddressRequest addressRequest) {
//        Address address = convertToAddress(addressRequest);
//        addressService.addAddress(address);
//        return new ResponseEntity<>("Address added successfully", HttpStatus.CREATED);
//    }
//
//    // Update address by ID (accepts AddressRequest for updating)
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateAddress(@PathVariable int id, @RequestBody AddressRequest addressRequest) {
//        Address address = convertToAddress(addressRequest);
//        addressService.updateAddress(id, address);
//        return new ResponseEntity<>("Address updated successfully", HttpStatus.OK);
//    }
//
//    // Delete address by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteAddress(@PathVariable int id) {
//        addressService.deleteAddress(id);
//        return new ResponseEntity<>("Address deleted successfully", HttpStatus.NO_CONTENT);
//    }
//}
