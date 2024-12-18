package com.BookStore.App.Service.Impl;

import com.BookStore.App.Model.Address;
import com.BookStore.App.Model.Author;
import com.BookStore.App.Repository.AddressRepository;
import com.BookStore.App.Repository.AuthorRepository;
import com.BookStore.App.Service.AuthorService;
import com.BookStore.App.Service.Exception.AddressNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
	
    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private AddressRepository addressRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author addAuthor(Author author, int addressId) throws AddressNotFoundException {
    	Optional<Address> addressOptional = addressRepository.findById(addressId);
    	 
    	if(addressOptional.isEmpty()) {
    		throw new AddressNotFoundException();
    	}
    	Address address = addressOptional.get();
    	
    	Author newAuthor = new Author(author.getFirstName(), author.getLastName(), address);
        return authorRepository.save(newAuthor);
    }

    public Author updateAuthor(int id, Author author){
    	Author newAuthor = authorRepository.findById(id).orElse(null);
        if(newAuthor != null) {
        	newAuthor.setFirstName(author.getFirstName());
        	newAuthor.setLastName(author.getLastName());
        	newAuthor.setUpdatedDate(LocalDateTime.now());
        	return authorRepository.save(newAuthor);         	
        }
        else
        	return null;
    }

    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }


}
