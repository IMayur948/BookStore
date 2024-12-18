package com.BookStore.App.Repository;

public interface BookStockRepository {

    int getStockById(int bookId);
    void updateStockIn(int bookId, int amount);
    void updateStockOut(int bookId, int amount);
}
