package com.BookStore.App.Repository.Impl;

import com.BookStore.App.Model.Book;
import com.BookStore.App.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Book> bookRowMapper = (rs, rowNum) -> new Book(
            rs.getInt("id"),
            rs.getString("title"),
            rs.getString("author"),
            rs.getString("publisher")
    );

    public List<Book> getAllBooks() {
        String sql = "SELECT id, title, author, publisher FROM books WHERE deleted = false";
        return jdbcTemplate.query(sql, bookRowMapper);
    }

    public void insert(Book book) {
        String sql = "INSERT INTO books (id, title, author, publisher) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher());
    }

    public void delete(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    public void remove(int id) {
        String sql = "UPDATE books SET deleted = ? WHERE id = ?";
        boolean deleted = true;
        jdbcTemplate.update(sql, deleted, id);
    }

    public void update(int id, Book book) {
        String sql = "UPDATE books SET title = ?, author = ?, publisher = ? WHERE id = ?";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getPublisher(), id);
    }

    public Book getById(int id) {
        String sql = "SELECT id, title, author, publisher FROM books WHERE id = ? AND deleted = false";
        return jdbcTemplate.queryForObject(sql, bookRowMapper, id);
    }

    public Book getByTitle(String title) {
        String sql = "SELECT id, title, author, publisher FROM books WHERE title = ? AND deleted = false";
        return jdbcTemplate.queryForObject(sql, bookRowMapper, title);
    }

    public List<Book> getByAuthor(String author) {
        String sql = "SELECT id, title, author, publisher FROM books WHERE author = ? AND deleted = false";
        return jdbcTemplate.query(sql, bookRowMapper, author);
    }

    public List<Book> getByPublisher(String publisher) {
        String sql = "SELECT id, title, author, publisher FROM books WHERE publisher = ? AND deleted = false";
        return jdbcTemplate.query(sql, bookRowMapper, publisher);
    }

    public List<Book> getByAuthorAndPublisher(String author, String publisher) {
        String sql = "SELECT id, title, author, publisher FROM books WHERE author = ? AND publisher = ? AND deleted = false";
        return jdbcTemplate.query(sql, bookRowMapper, author, publisher);
    }
}
