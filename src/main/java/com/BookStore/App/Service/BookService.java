package com.BookStore.App.Service;

import com.BookStore.App.Model.Book;
import com.BookStore.App.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    public List<Book> getBooks() {
        List<Book> books = bookRepo.getAllBooks();
        return books;
    }

    public void insert(Book book) {
        bookRepo.insert(book);
    }

    public void delete(int id) {
        bookRepo.delete(id);
    }

    public void update(int id, Book book) {
        bookRepo.update(id, book);
    }

    public Book getById(int id) {
        return bookRepo.getById(id);
    }

    public Book getByTitle(String title) {
        return bookRepo.getByTitle(title);
    }

    public List<Book> getByAuthor(String author) {
        return bookRepo.getByAuthor(author);
    }

     public List<Book> getByPublisher(String publisher) {
        return bookRepo.getByPublisher(publisher);
    }

     public List<Book> getByAuthorAndPublisher(String author, String publisher) {
        return bookRepo.getByAuthorAndPublisher(author, publisher);
    }
}