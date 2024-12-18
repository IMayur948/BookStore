package com.BookStore.App.Controller;

import com.BookStore.App.Controller.POJO.AuthorRequest;
import com.BookStore.App.Controller.POJO.AuthorResponse;
import com.BookStore.App.Model.Author;
import com.BookStore.App.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookStore/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // Convert AuthorRequest to Author
    private Author convertToAuthor(AuthorRequest authorRequest) {
        Author author = new Author();
        author.setFirstName(authorRequest.getFirstName());
        author.setLastName(authorRequest.getLastName());
        author.setAddress(authorRequest.getAddress());
        return author;
    }

    // Convert Author to AuthorResponse
    private AuthorResponse convertToAuthorResponse(Author author) {
        return new AuthorResponse(
            author.getId(),
            author.getFirstName(),
            author.getLastName(),
            author.getAddress()
        );
    }

    // Convert List<Author> to List<AuthorResponse>
    private List<AuthorResponse> convertToAuthorResponseList(List<Author> authors) {
        List<AuthorResponse> authorResponses = new ArrayList<>();
        for (Author author : authors) {
            authorResponses.add(convertToAuthorResponse(author));
        }
        return authorResponses;
    }

    // Get all authors
    @GetMapping("/getAll")
    public ResponseEntity<List<AuthorResponse>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        List<AuthorResponse> authorResponses = convertToAuthorResponseList(authors);
        return new ResponseEntity<>(authorResponses, HttpStatus.OK);
    }

    // Get author by ID
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthor(@PathVariable int id) {
        Author author = authorService.getAuthorById(id);
        if (author != null) {
            AuthorResponse authorResponse = convertToAuthorResponse(author);
            return new ResponseEntity<>(authorResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Add a new author
    @PostMapping("/add")
    public ResponseEntity<String> addAuthor(@RequestBody AuthorRequest authorRequest) {
        Author author = convertToAuthor(authorRequest);
        authorService.addAuthor(author);
        return new ResponseEntity<>("Author added successfully", HttpStatus.CREATED);
    }

    // Update author
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable int id, @RequestBody AuthorRequest authorRequest) {
        Author author = convertToAuthor(authorRequest);
        authorService.updateAuthor(id, author);
        return new ResponseEntity<>("Author updated successfully", HttpStatus.OK);
    }

    // Delete author
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>("Author deleted successfully", HttpStatus.NO_CONTENT);
    }
}