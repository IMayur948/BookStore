package com.BookStore.App.Repository;

import com.BookStore.App.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> getAllBooks() {
        String sql = "select * from books where isDeleted = false";
        RowMapper<Book> mapper = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher")
                );
            }
        };
        List<Book> results = jdbcTemplate.query(sql, mapper);
        return results;
    }

    public void insert(Book book){
        String sql = "insert into books(id,title,author,publisher) values(?,?,?,?)";
        jdbcTemplate.update(sql, book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher());
    }

    public void delete(int id) {
        String sql = "delete from books where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void update(int id, Book book) {
        String sql = "update books set title = ?, author = ?, publisher = ? where id = ?";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getPublisher(), book.getId());
    }

    public Book getById(int id) {
        String sql = "select * from books where id = ? and isDeleted = false";
        RowMapper<Book> mapper = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher")
                );
            }
        };
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }
     public Book getByTitle(String title) {
        String sql = "select * from books where title = ? and isDeleted = false";
        RowMapper<Book> mapper = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher")
                );
            }
        };
        return jdbcTemplate.queryForObject(sql, mapper, title);
    }
    public List<Book> getByAuthor(String author) {
        String sql = "select * from books where author = ? and isDeleted = false";
        RowMapper<Book> mapper = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher")
                );
            }
        };
        return jdbcTemplate.query(sql, mapper, author);
    }

     public List<Book> getByPublisher(String publisher) {
        String sql = "select * from books where publisher = ? and isDeleted = false";
        RowMapper<Book> mapper = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher")
                );
            }
        };
        return jdbcTemplate.query(sql, mapper, publisher);
    }

     public List<Book> getByAuthorAndPublisher(String author, String publisher) {
        String sql = "select * from books where author = ? and publisher = ? and isDeleted = false";
        RowMapper<Book> mapper = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher")
                );
            }
        };
        return jdbcTemplate.query(sql, mapper, author, publisher);
    }
}
