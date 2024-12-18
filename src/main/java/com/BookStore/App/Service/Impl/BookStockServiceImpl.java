package com.BookStore.App.Service.Impl;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStore.App.Model.BookStock;
import com.BookStore.App.Repository.BookStockRepository;
import com.BookStore.App.Service.BookStockService;

@Service
public class BookStockServiceImpl implements BookStockService {

	@Autowired
	private BookStockRepository bookStockRepository;
	
	public BookStock addBookStock(BookStock bookStock) {
		return bookStockRepository.save(bookStock);
	}
	
    public int getStockById(int book_id) {
        
    	BookStock bookStock =  bookStockRepository.findByBookId(book_id);
    	int stock = bookStock.getStockIn()-bookStock.getStockOut();
    	return stock;
    }

    public BookStock updateStockIn(int id, int amount){
    	Optional<BookStock> bookStockOptional = bookStockRepository.findById(id);
    	if(bookStockOptional.isPresent()) {
    		BookStock bookStock = bookStockOptional.get();
    		bookStock.setStockIn(amount);
    		return bookStockRepository.save(bookStock);
    	}
    	return null;
    }

    public BookStock updateStockOut(int id, int amount) {
    	Optional<BookStock> bookStockOptional = bookStockRepository.findById(id);
    	if(bookStockOptional.isPresent()) {
    		BookStock bookStock = bookStockOptional.get();
    		bookStock.setStockOut(amount);
    		return bookStockRepository.save(bookStock);
    	}
    	return null;

    }

 	public List<BookStock> getAll() {
 		
 		return bookStockRepository.findAll();
	}
}
