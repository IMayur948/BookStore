package com.BookStore.App.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStore.App.Repository.BookStockRepository;
import com.BookStore.App.Service.BookStockService;

@Service
public class BookStockServiceImpl implements BookStockService {

	@Autowired
	private BookStockRepository bookStockRepository;
    public int getStockById(int book_id) {
        return bookStockRepository.getStockById(book_id);
    }

    public void updateStockIn(int id, int amount){
        bookStockRepository.updateStockIn(id, amount);
    }

    public void updateStockOut(int id, int amount) {
        bookStockRepository.updateStockOut(id, amount);

    }
}
