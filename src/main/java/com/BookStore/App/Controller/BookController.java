package com.BookStore.App.Controller;

import com.BookStore.App.Model.Book;
import com.BookStore.App.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/bookStore")
public class BookController {
    @Autowired
    private BookService bookService;

    //get all books
    @GetMapping("/getAll")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    //add new book
    @PostMapping("/add")
    public void insert(@RequestBody Book book){
        bookService.insert(book);
    }

    // delete book by ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }

    //update book by ID
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Book book) {
        bookService.update(id, book);
    }

    //get a book by ID
    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        return bookService.getById(id);
    }

    //get books by title
    @GetMapping("/title/{title}")
    public Book getBooksByTitle(@PathVariable String title) {
        return bookService.getByTitle(title);
    }

    //get books by author
    @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.getByAuthor(author);
    }

    //get books by publisher
    @GetMapping("/publisher/{publisher}")
    public List<Book> getBooksByPublisher(@PathVariable String publisher) {
        return bookService.getByPublisher(publisher);
    }

    //get books by author and publisher
    @GetMapping("/author/{author}/publisher/{publisher}")
    public List<Book> getBooksByAuthorAndPublisher(@PathVariable String author, @PathVariable String publisher) {
        return bookService.getByAuthorAndPublisher(author, publisher);
    }
}