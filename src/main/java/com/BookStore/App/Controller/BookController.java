package com.BookStore.App.Controller;

import com.BookStore.App.Controller.POJO.BookRequest;
import com.BookStore.App.Controller.POJO.BookResponse;
import com.BookStore.App.Model.Book; 
import com.BookStore.App.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookStore/api")
public class BookController {
	
    @Autowired
    private BookService bookService;

    
 // BookRequest to Book conversion
    private Book convertToBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setPublisher(bookRequest.getPublisher());
        return book;
    }

    // Book to BookResponse conversion
    private BookResponse convertToBookResponse(Book book) {
        return new BookResponse(
            book.getId(),
            book.getTitle(),
            book.getAuthor(),
            book.getPublisher()
        );
    }

    // BookList to BookResponseList conversion
    private List<BookResponse> convertToBookResponseList(List<Book> books) {
        List<BookResponse> bookResponses = new ArrayList<>();
        for (Book book : books) {
            bookResponses.add(convertToBookResponse(book));
        }
        return bookResponses;
    }


    // Get all books
    @GetMapping("/getAll")
    public ResponseEntity<List<BookResponse>> getBooks() {
        List<Book> books = bookService.getBooks();
        return new ResponseEntity<>(convertToBookResponseList(books), HttpStatus.OK);
    }

    // Add new book
    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody BookRequest bookRequest) {
        Book book = convertToBook(bookRequest);
        book.setCreatedDate(LocalDateTime.now());
        bookService.addBook(book);
        return new ResponseEntity<>("Book added successfully", HttpStatus.CREATED);
    }

    // Remove book by ID but don't from DB
    @PutMapping("/remove/{id}")
    public ResponseEntity<String> remove(@PathVariable int id) {
    	bookService.remove(id);
    	return new ResponseEntity<>("Book with id " + id + " removed Successfully", HttpStatus.OK);
    }


//    // Delete book by ID from DB
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> delete(@PathVariable int id) {
//        bookService.delete(id);
//        return new ResponseEntity<>("Book with id " + id + " deleted Successfully", HttpStatus.OK);
//    }
//
//
//    // Update book by ID
//    @PutMapping("/{id}")
//    public ResponseEntity<String> update(@PathVariable int id, @RequestBody BookBean bookBean) {
//        Book book = convertToBook(bookBean);
//        book.setUpdatedDate(LocalDateTime.now());
//        bookService.update(id, book);
//        return new ResponseEntity<>(book.toString() + " updated Successfully", HttpStatus.OK);
//    }
//
    // Get a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable int id) {
        Book book = bookService.getById(id);
        return new ResponseEntity<>(convertToBookResponse(book), HttpStatus.OK);
    }
//
//    // Get books by title
//    @GetMapping("/title")
//    public ResponseEntity<BookBean> getBooksByTitle(@RequestParam String title) {
//        Book book = bookService.getByTitle(title);
//        return new ResponseEntity<>(convertToBookBean(book), HttpStatus.OK);
//    }
//
//    // Get books by author
//    @GetMapping("/author")
//    public ResponseEntity<List<BookBean>> getBooksByAuthor(@RequestParam String author) {
//        List<Book> books = bookService.getByAuthor(author);
//        return new ResponseEntity<>(convertToBookBeanList(books), HttpStatus.OK);
//    }
//
//    // Get books by publisher
//    @GetMapping("/publisher")
//    public ResponseEntity<List<BookBean>> getBooksByPublisher(@RequestParam String publisher) {
//        List<Book> books = bookService.getByPublisher(publisher);
//        return new ResponseEntity<>(convertToBookBeanList(books), HttpStatus.OK);
//    }
//
//    // Get books by author and publisher
//    @GetMapping("/authorPublisher")
//    public ResponseEntity<List<BookBean>> getBooksByAuthorAndPublisher(@RequestParam String author, @RequestParam String publisher) {
//        List<Book> books = bookService.getByAuthorAndPublisher(author, publisher);
//        return new ResponseEntity<>(convertToBookBeanList(books), HttpStatus.OK);
//    }
}
