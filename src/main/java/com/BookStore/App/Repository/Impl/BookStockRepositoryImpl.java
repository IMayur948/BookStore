//package com.BookStore.App.Repository.Impl;
//
//import java.time.LocalDateTime;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.BookStore.App.Repository.BookStockRepository;
//
//@Repository
//public class BookStockRepositoryImpl implements BookStockRepository {
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	public int getStockById(int bookId) {
//        String sql = "SELECT stock_in - stock_out AS current_stock FROM book_stock WHERE book_id = ?";
//        return jdbcTemplate.queryForObject(sql, Integer.class, bookId);
//    }
//
//
//    public void updateStockIn(int bookId, int amount) {
//        String sql = "UPDATE book_stock SET stock_in = stock_in + ?, updated_date = ? WHERE book_id = ?";
//        jdbcTemplate.update(sql, amount, LocalDateTime.now(), bookId);
//    }
//
//    public void updateStockOut(int bookId, int amount) {
//        String sql = "UPDATE book_stock SET stock_out = stock_out + ?, updated_date = ? WHERE book_id = ?";
//        jdbcTemplate.update(sql, amount, LocalDateTime.now(), bookId);
//    }
//
//
//
//}
