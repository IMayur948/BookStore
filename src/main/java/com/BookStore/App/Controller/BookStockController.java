package com.BookStore.App.Controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.App.Controller.POJO.BookStockRequest;
import com.BookStore.App.Controller.POJO.BookStockResponse;
import com.BookStore.App.Controller.POJO.GetBookStockResponse;
import com.BookStore.App.Model.BookStock;
import com.BookStore.App.Service.BookStockService;

 

@RestController
@RequestMapping("/bookStore/api/stock")
public class BookStockController {

	@Autowired
	private BookStockService bookStockService;
	
    @GetMapping("/{id}")
    public ResponseEntity<String> getStockById(@PathVariable int id) {
        int stock = bookStockService.getStockById(id);
        return new ResponseEntity<>(stock + " books of Book_id :" + id, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<GetBookStockResponse> getBookStock(){
    	List<BookStock> bookStockResponse = bookStockService.getAll();
    	List<BookStockResponse> bokBookStockResponseList = bookStockResponse.stream()
    			.map(bookStockResponce -> new BookStockResponse(bookStockResponce.getId(),bookStockResponce.getBookId(), bookStockResponce.getStockIn(),bookStockResponce.getStockOut()))
    			.collect(Collectors.toList());
    	return new ResponseEntity<>(new GetBookStockResponse(bokBookStockResponseList), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<GetBookStockResponse> addBookStock(@RequestBody BookStockRequest bookStockRequest){
    	 
    	BookStock bookStock = new BookStock(bookStockRequest.getBookId(), bookStockRequest.getStockIn(),bookStockRequest.getStockOut());
    	BookStock newBookStock = bookStockService.addBookStock(bookStock);
    	BookStockResponse bookStockResponse = new BookStockResponse(
    			newBookStock.getId(),
    			newBookStock.getBookId(),
    			newBookStock.getStockIn(),
    			newBookStock.getStockOut());
    	List<BookStockResponse> bookStockResponseList = Collections.singletonList(bookStockResponse);
    	return new ResponseEntity<>(new GetBookStockResponse(bookStockResponseList), HttpStatus.CREATED);
    	
    }
    
    @PutMapping("/stockIn/{id}")
    public ResponseEntity<String> updateStockIn(@PathVariable int id, @RequestParam int amount) {
        bookStockService.updateStockIn(id, amount);
        return new ResponseEntity<>("Stock inserted successfully", HttpStatus.OK);
    }

    @PutMapping("/stockOut/{id}")
    public ResponseEntity<String> updateStockOut(@PathVariable int id, @RequestParam int amount) {
        bookStockService.updateStockOut(id, amount);
        return new ResponseEntity<>("Stock out successful", HttpStatus.OK);
    }
}
