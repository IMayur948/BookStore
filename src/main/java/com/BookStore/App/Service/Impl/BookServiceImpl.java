package com.BookStore.App.Service.Impl;

import com.BookStore.App.Model.Book;
import com.BookStore.App.Repository.BookRepository; 
import com.BookStore.App.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {
	
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    public void remove(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book != null) {
        	book.setDeleted(true);
        }
        bookRepository.save(book);
    }

    public Book getById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book getByTitle(String title) {
        return bookRepository.findByTitle(title).orElse(null);
    }

//    public void update(int id, Book book) {
//        bookRepository.update(id, book);
//    }
    
//    public List<Book> getByAuthor(String author) {
//        return bookRepository.findByAuthor(author);
//    }


//     public List<Book> getByPublisher(String publisher) {
//        return bookRepository.getByPublisher(publisher);
//    }
//
//     public List<Book> getByAuthorAndPublisher(String author, String publisher) {
//        return bookRepository.getByAuthorAndPublisher(author, publisher);
//    }
 
}