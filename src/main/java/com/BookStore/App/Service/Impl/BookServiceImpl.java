package com.BookStore.App.Service.Impl;

import com.BookStore.App.Model.Address;
import com.BookStore.App.Model.Author;
import com.BookStore.App.Model.Book;
import com.BookStore.App.Model.BookStock;
import com.BookStore.App.Model.Publisher;
import com.BookStore.App.Repository.AuthorRepository;
import com.BookStore.App.Repository.BookRepository;
import com.BookStore.App.Repository.BookStockRepository;
import com.BookStore.App.Repository.PublisherRepository;
import com.BookStore.App.Service.BookService;
import com.BookStore.App.Service.Exception.AuthorNotFoundException;
import com.BookStore.App.Service.Exception.BookNotFoundException;
import com.BookStore.App.Service.Exception.PublisherNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService {
	
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookStockRepository bookStockRepository;
    
    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private PublisherRepository publisherRepository;
    
    public List<Book> getBooks() {
        List<Book> books = bookRepository.findAll();
        
        //get books with deleted false only
        List<Book> newBooks = books.stream()
        		.filter(book -> book.isDeleted() == false)
        		.collect(Collectors.toList());
        return newBooks;
    }

    public Book addBook(String title, int authorId, int publisherId) throws AuthorNotFoundException, PublisherNotFoundException {
    	Optional<Author> authorOptional = authorRepository.findById(authorId);
     	
    	if(authorOptional.isEmpty()) {
    		throw new AuthorNotFoundException();
    	}
    	Author author = authorOptional.get();
    	
    	Optional<Publisher> publisherOptional = publisherRepository.findById(publisherId);
     	
    	if(publisherOptional.isEmpty()) {
    		throw new PublisherNotFoundException();
    	}
    	Publisher publisher = publisherOptional.get();
    	
    	Book book = new Book(title, author,publisher);
    	book.setCreatedDate(LocalDateTime.now());
    	Book newBook = bookRepository.save(book);
    	
    	//initializing stock
    	BookStock bookStock = new BookStock(newBook.getId(), 0,0);
    	bookStockRepository.save(bookStock);
    	
    	return newBook;    
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

    public Book update(int id, String title, int authorId, int publisherId)  throws AuthorNotFoundException, PublisherNotFoundException, BookNotFoundException {
    	
    	Optional<Book> bookOptional = bookRepository.findById(id);
    	if(bookOptional.isEmpty()) {
    		throw new BookNotFoundException();
    	}
    	Book existingBook = bookOptional.get();
    
    	
    	Optional<Author> authorOptional = authorRepository.findById(authorId);
    	if(authorOptional.isEmpty()) {
    		throw new AuthorNotFoundException();
    	}
    	Author author = authorOptional.get();
    	
    	
    	Optional<Publisher> publisherOptional = publisherRepository.findById(publisherId);
    	if(publisherOptional.isEmpty()) {
    		throw new PublisherNotFoundException();
    	}
    	Publisher publisher = publisherOptional.get();
    	
    	if(existingBook != null) {
			existingBook.setTitle(title);
			existingBook.setAuthor(author);
			existingBook.setPublisher(publisher);  
			existingBook.setUpdatedDate(LocalDateTime.now());
    		return bookRepository.save(existingBook);
    	}
    	else 
    		return null;
    	
    }

//    public List<Book> getByAuthor(int author) {
//        return bookRepository.findByAuthor(author);
//    }
//    
//
//    public List<Book> getByPublisher(int publisher) {
//    	return bookRepository.findByPublisher(publisher);
//    }
//
//    public List<Book> getByAuthorOrPublisher(int author, int publisher) {
//        return bookRepository.findByAuthorOrPublisher(author, publisher);
//    }

    
}