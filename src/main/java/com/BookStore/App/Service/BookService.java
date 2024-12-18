package com.BookStore.App.Service;

import com.BookStore.App.Model.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    Book addBook(Book book);

    void delete(int id);

    Book getById(int id);
    
    void remove(int id);

//    void update(int id, Book book);
    
//    Book getByTitle(String title);
//
//    List<Book> getByAuthor(String author);
//
//    List<Book> getByPublisher(String publisher);
//
//    List<Book> getByAuthorAndPublisher(String author, String publisher);
//

    //stock related
    
//    int getStockById(int id);
//
//    void updateStockIn(int id, int amount);
//
//    void updateStockOut(int id, int amount);
}