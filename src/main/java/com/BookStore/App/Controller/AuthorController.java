package com.BookStore.App.Controller;

import com.BookStore.App.Controller.POJO.AuthorRequest;
import com.BookStore.App.Controller.POJO.AuthorResponse;
import com.BookStore.App.Controller.POJO.GetAuthorResponse;
import com.BookStore.App.Model.Author;
import com.BookStore.App.Service.AuthorService;
import com.BookStore.App.Service.Exception.AddressNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookStore/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // Get all authors
    @GetMapping
    public ResponseEntity<GetAuthorResponse> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        List<AuthorResponse> authorResponseList = authors.stream()
                .map(author -> new AuthorResponse(author.getId(), author.getFirstName(),author.getLastName(), author.getAddress().getAddressString()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(new GetAuthorResponse(authorResponseList), HttpStatus.OK);
    }

    
    // Get author by ID
    @GetMapping("/{id}")
    public ResponseEntity<GetAuthorResponse> getAuthor(@PathVariable int id) {
    	
        Author author = authorService.getAuthorById(id);
        
        if (author != null) {
            AuthorResponse authorResponse = new AuthorResponse(author.getId(),author.getFirstName(),author.getLastName(),author.getAddress().getAddressString());
            List<AuthorResponse> authorResponseList = Collections.singletonList(authorResponse);
            return new ResponseEntity<>(new GetAuthorResponse(authorResponseList), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Add a new author
    @PostMapping
    public ResponseEntity<GetAuthorResponse> addAuthor(@RequestBody AuthorRequest authorRequest) throws AddressNotFoundException {
    	
        Author author = new Author(authorRequest.getFirstName(),authorRequest.getLastName(),null);
        
        Author newAuthor = authorService.addAuthor(author,authorRequest.getAddressId());

        AuthorResponse authorResponse = new AuthorResponse(newAuthor.getId(),newAuthor.getFirstName(),newAuthor.getLastName(),newAuthor.getAddress().getAddressString());
        List<AuthorResponse> authorResponseList = Collections.singletonList(authorResponse);
        return new ResponseEntity<>(new GetAuthorResponse(authorResponseList), HttpStatus.CREATED);
    }

    // Update author
    @PutMapping("/{id}")
    public ResponseEntity<GetAuthorResponse> updateAuthor(@PathVariable int id, @RequestBody AuthorRequest authorRequest) {
        
    	Author author = new Author(authorRequest.getFirstName(),authorRequest.getLastName(),null);
        
    	Author newAuthor = authorService.updateAuthor(id, author);

        AuthorResponse authorResponse = new AuthorResponse(newAuthor.getId(),newAuthor.getFirstName(),newAuthor.getLastName(),newAuthor.getAddress().getAddressString());
       
        List<AuthorResponse> authorResponseList = Collections.singletonList(authorResponse);
        return new ResponseEntity<>(new GetAuthorResponse(authorResponseList), HttpStatus.OK);
    }

    // Delete author
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>("Author deleted successfully", HttpStatus.NO_CONTENT);
    }
}
