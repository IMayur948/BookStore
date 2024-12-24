package com.BookStore.App.Controller;

import com.BookStore.App.Controller.POJO.BookRequest;
import com.BookStore.App.Controller.POJO.BookResponse;
import com.BookStore.App.Controller.POJO.GetBookResponse;
import com.BookStore.App.Model.Book; 
import com.BookStore.App.Service.BookService;
import com.BookStore.App.Service.Exception.AuthorNotFoundException;
import com.BookStore.App.Service.Exception.BookNotFoundException;
import com.BookStore.App.Service.Exception.PublisherNotFoundException;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookStore/api")
public class BookController {
	
    @Autowired
    private BookService bookService;
 
    // Get all books
    @GetMapping
    public ResponseEntity<GetBookResponse> getBooks() {
        List<Book> books = bookService.getBooks();
        List<BookResponse> bookResponseList = books.stream()
        		.map(book -> new BookResponse(book.getId(), book.getTitle(), book.getAuthor().getName(), book.getPublisher().getName()))
        		.collect(Collectors.toList());
        return new ResponseEntity<>(new GetBookResponse(bookResponseList), HttpStatus.OK);
    }

    // Add new book
    @PostMapping("/add")
    public ResponseEntity<GetBookResponse> addBook(@Valid @RequestBody BookRequest bookRequest) throws AuthorNotFoundException, PublisherNotFoundException {
    	
//        Book book = new Book(bookRequest.getTitle(), bookRequest.getAuthor(), bookRequest.getPublisher());
        Book newBook = bookService.addBook(bookRequest.getTitle(), bookRequest.getAuthorId(), bookRequest.getPublisherId());
        
        BookResponse bookResponse = new BookResponse(newBook.getId(), newBook.getTitle(), newBook.getAuthor().getName(), newBook.getPublisher().getName());
        List<BookResponse> bookResponseList = Collections.singletonList(bookResponse);
        return new ResponseEntity<>(new GetBookResponse(bookResponseList) ,HttpStatus.CREATED);
    }

    // Remove book by ID but don't from DB
    @PutMapping("/remove/{id}")
    public ResponseEntity<String> remove(@PathVariable int id) {
    	bookService.remove(id);
    	return new ResponseEntity<>("Book with id " + id + " removed Successfully", HttpStatus.OK);
    }


    // Delete book by ID from DB
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        bookService.delete(id);
        return new ResponseEntity<>("Book with id " + id + " deleted Successfully", HttpStatus.OK);
    }


    // Update book by ID
    @PutMapping("/{id}")
    public ResponseEntity<GetBookResponse> update(@PathVariable int id, @RequestBody BookRequest bookRequest)  throws AuthorNotFoundException, PublisherNotFoundException, BookNotFoundException{
//        Book book = new Book(bookRequest.getTitle(), bookRequest.getAuthorId(), bookRequest.getPublisherId());
//        Book newBook = bookService.update(id, book);
    	
    	Book newBook = bookService.update(id, bookRequest.getTitle(), bookRequest.getAuthorId(), bookRequest.getPublisherId());

        BookResponse bookResponse = new BookResponse(newBook.getId(), newBook.getTitle(), newBook.getAuthor().getName(), newBook.getPublisher().getName());
        List<BookResponse> bookResponseList = Collections.singletonList(bookResponse);
        
        return new ResponseEntity<>(new GetBookResponse(bookResponseList), HttpStatus.OK);
    }

    // Get a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<GetBookResponse> getBook(@PathVariable int id) {
        Book newBook = bookService.getById(id);
        BookResponse bookResponse = new BookResponse(newBook.getId(), newBook.getTitle(), newBook.getAuthor().getName(), newBook.getPublisher().getName());
        List<BookResponse> bookResponseList = Collections.singletonList(bookResponse);
        return new ResponseEntity<>(new GetBookResponse(bookResponseList), HttpStatus.OK);
    }

    // Get books by title
    @GetMapping(params = {"title"})
    public ResponseEntity<GetBookResponse> getBooksByTitle(@RequestParam String title) {
        Book newBook = bookService.getByTitle(title);
        BookResponse bookResponse = new BookResponse(newBook.getId(), newBook.getTitle(), newBook.getAuthor().getName(), newBook.getPublisher().getName());
        return new ResponseEntity<>(new GetBookResponse(Collections.singletonList(bookResponse)), HttpStatus.OK);
    }
    
    
//     Get books by author or publisher
    @GetMapping(params = {"author", "publisher"})
    public ResponseEntity<GetBookResponse> getBooksByAuthorOrPublisher(@RequestParam(required = false) int author, @RequestParam(required = false) int publisher) throws AuthorNotFoundException, PublisherNotFoundException {
    	List<Book> books = bookService.getByAuthorOrPublisher(author, publisher);
    	List<BookResponse> bookResponseList = books.stream()
    			.map(book -> new BookResponse(book.getId(), book.getTitle(), book.getAuthor().getName(), book.getPublisher().getName()))
    			.collect(Collectors.toList());
    	return new ResponseEntity<>(new GetBookResponse(bookResponseList), HttpStatus.OK);
    }

    
    
    // Get books by author
    @GetMapping(params = {"author"})
    public ResponseEntity<GetBookResponse> getBooksByAuthor(@RequestParam int author) {
        List<Book> books = bookService.getByAuthor(author);
        List<BookResponse> bookResponseList = books.stream()
        		.map(book -> new BookResponse(book.getId(), book.getTitle(), book.getAuthor().getName(), book.getPublisher().getName()))
        		.collect(Collectors.toList());
        return new ResponseEntity<>(new GetBookResponse(bookResponseList), HttpStatus.OK);
    }

    
    // Get books by publisher
    @GetMapping(params = {"publisher"})
    public ResponseEntity<GetBookResponse> getBooksByPublisher(@RequestParam int publisher) {
        List<Book> books = bookService.getByPublisher(publisher);
        List<BookResponse> bookResponseList = books.stream()
        		.map(book -> new BookResponse(book.getId(), book.getTitle(), book.getAuthor().getName(), book.getPublisher().getName()))
        		.collect(Collectors.toList());
        return new ResponseEntity<>(new GetBookResponse(bookResponseList), HttpStatus.OK); 
    }

}
