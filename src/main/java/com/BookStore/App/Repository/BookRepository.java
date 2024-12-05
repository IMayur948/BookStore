package com.BookStore.App.Repository;

import com.BookStore.App.Model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAllBooks();

    void insert(Book book);

    void delete(int id);

    void remove(int id);

    void update(int id, Book book);

    Book getById(int id);

    Book getByTitle(String title);

    List<Book> getByAuthor(String author);

    List<Book> getByPublisher(String publisher);

    List<Book> getByAuthorAndPublisher(String author, String publisher);
}
