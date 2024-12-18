package com.BookStore.App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookStore.App.Model.BookStock;

@Repository
public interface BookStockRepository extends JpaRepository<BookStock, Integer> {

	BookStock findByBookId(int book_id);


//    int getStockById(int bookId);
//    void updateStockIn(int bookId, int amount);
//    void updateStockOut(int bookId, int amount);
}
