package com.BookStore.App.Service.Impl;

import com.BookStore.App.Model.Address;
import com.BookStore.App.Model.Publisher;
import com.BookStore.App.Repository.AddressRepository;
import com.BookStore.App.Repository.PublisherRepository;
import com.BookStore.App.Service.PublisherService;
import com.BookStore.App.Service.Exception.AddressNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
 
@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;
    
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getPublisherById(int id) {
        return publisherRepository.findById(id).orElse(null);
    }

    @Override
    public Publisher addPublisher(Publisher publisher, int addressId) throws AddressNotFoundException {
    	Optional<Address> addressOptional = addressRepository.findById(addressId);
    	System.out.println(addressOptional.get());
    	
    	if(addressOptional.isEmpty()) {
    		throw new AddressNotFoundException();
    	}
    	Address address = addressOptional.get();
    	
    	Publisher newPublisher = new Publisher(publisher.getFirstName(), publisher.getLastName(), address);
    	return publisherRepository.save(newPublisher);
    }

    @Override
    public Publisher updatePublisher(int id, Publisher publisher) {
    	Publisher existingPublisher = publisherRepository.findById(id).orElse(null);
    	if(existingPublisher != null) {
    		existingPublisher.setFirstName(publisher.getFirstName());
    		existingPublisher.setLastName(publisher.getLastName());    		
    		return publisherRepository.save(existingPublisher);
    	}
    	else return null;
    }

    @Override
    public boolean deletePublisher(int id) {
    	if(publisherRepository.existsById(id)) {    		
    		publisherRepository.deleteById(id);
    		return true;
    	}
    	else
    		return false;
    	
    }
}
