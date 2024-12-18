package com.BookStore.App.Service.Impl;

import com.BookStore.App.Model.Author;
import com.BookStore.App.Repository.AuthorRepository;
import com.BookStore.App.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
	
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(int id, Author author){
    	Author newAuthor = authorRepository.findById(id).orElse(null);
        
        newAuthor.setFirstName(author.getFirstName());
    	newAuthor.setLastName(author.getLastName());
        newAuthor.setAddress(author.getAddress() );
        
        return authorRepository.save(newAuthor); 
        
    }

    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }


}
