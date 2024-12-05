package com.BookStore.App.Controller;

import com.BookStore.App.Model.Book;
import com.BookStore.App.Model.BookBean;
import com.BookStore.App.Service.Impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/bookStore")
public class BookController {
    @Autowired
    private BookServiceImpl bookServiceImpl;

    // Book To BookBean
    private BookBean convertToBookBean(Book book){
        return new BookBean(book.getId(), book.getTitle(),book.getAuthor(),book.getPublisher());
    }
    // BookList to BookBeanList
    private List<BookBean> convertToBookBeanList(List<Book> books){
        List<BookBean> bookBeans = new ArrayList<>();
        for(Book book : books){
            bookBeans.add(convertToBookBean(book));
        }
        return bookBeans;
    }
    //get all books
    @GetMapping("/getAll")
    public List<BookBean> getBooks() {
        List<Book> books = bookServiceImpl.getBooks();
        return convertToBookBeanList(books);
    }

    //add new book
    @PostMapping("/add")
    public String insert(@RequestBody Book book){
        bookServiceImpl.insert(book);
        return (book.toString() + " inserted successfully");

    }

    // delete book by ID from DB
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        bookServiceImpl.delete(id);
        return "Book with id "+ id +" deleted Successfully";
    }

    // remove book by ID but don't from DB
    @PutMapping("/remove/{id}")
    public String remove(@PathVariable int id) {
        bookServiceImpl.remove(id);
        return "Book with id "+ id +" removed Successfully";
    }

    //update book by ID
    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Book book) {
        bookServiceImpl.update(id, book);
        return (book.toString() + " updated Successfully");
    }

    //get a book by ID
    @GetMapping("/{id}")
    public BookBean getBook(@PathVariable int id) {
        Book book = bookServiceImpl.getById(id);
        return convertToBookBean(book);
    }

    //get books by title
    @GetMapping("/title")
    public BookBean getBooksByTitle(@RequestParam String title) {
        Book book = bookServiceImpl.getByTitle(title);
        return convertToBookBean(book);
    }

    //get books by author
    @GetMapping("/author")
    public List<BookBean> getBooksByAuthor(@RequestParam String author) {
        List<Book> books =  bookServiceImpl.getByAuthor(author);
        return convertToBookBeanList(books);
    }

    //get books by publisher
    @GetMapping("/publisher")
    public List<Book> getBooksByPublisher(@RequestParam String publisher) {
        return bookServiceImpl.getByPublisher(publisher);
    }

    //get books by author and publisher
    @GetMapping("/authorPublisher")
    public List<BookBean> getBooksByAuthorAndPublisher(@RequestParam String author, @RequestParam String publisher) {
        List<Book> books = bookServiceImpl.getByAuthorAndPublisher(author, publisher);
        return convertToBookBeanList(books);
    }
}