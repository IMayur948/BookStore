package com.BookStore.App.Service;

import com.BookStore.App.Model.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    void insert(Book book);

    void delete(int id);

    void update(int id, Book book);

    Book getById(int id);

    Book getByTitle(String title);

    List<Book> getByAuthor(String author);

    List<Book> getByPublisher(String publisher);

    List<Book> getByAuthorAndPublisher(String author, String publisher);
}