package com.BookStore.App.Service;

public interface BookStockService {

    int getStockById(int id);

    void updateStockIn(int id, int amount);

    void updateStockOut(int id, int amount);

}
