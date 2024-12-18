package com.BookStore.App.Service;

import java.util.List;

import com.BookStore.App.Model.BookStock;

public interface BookStockService {

    int getStockById(int id);

    BookStock updateStockIn(int id, int amount);

    BookStock updateStockOut(int id, int amount);
    
    BookStock addBookStock(BookStock bookStock);

	List<BookStock> getAll();
}
