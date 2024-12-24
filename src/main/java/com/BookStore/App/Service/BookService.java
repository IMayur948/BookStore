package com.BookStore.App.Service;

import com.BookStore.App.Model.Book;
import com.BookStore.App.Service.Exception.AuthorNotFoundException;
import com.BookStore.App.Service.Exception.BookNotFoundException;
import com.BookStore.App.Service.Exception.PublisherNotFoundException;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    Book addBook(String title, int authorId, int publisherId) throws AuthorNotFoundException, PublisherNotFoundException;
    Book update(int id, String title, int authorId, int publisherId)  throws AuthorNotFoundException, PublisherNotFoundException, BookNotFoundException;
    void delete(int id);
    Book getById(int id);
    void remove(int id);
    Book getByTitle(String title);

    
//    Book addBook(Book book);
//    Book update(int id, Book book);

//    List<Book> getByAuthor(int author);
//
//    List<Book> getByPublisher(int publisher);
//
    List<Book> getByAuthorOrPublisher(int author, int publisher) throws AuthorNotFoundException, PublisherNotFoundException;

 
    
    //stock related
    
//    int getStockById(int id);
//
//    void updateStockIn(int id, int amount);
//
//    void updateStockOut(int id, int amount);
}