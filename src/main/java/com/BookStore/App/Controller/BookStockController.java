package com.BookStore.App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.App.Service.BookStockService;


@RestController
@RequestMapping("/bookStore/api/stock")
public class BookStockController {

	@Autowired
	private BookStockService bookStockService;
	
    @GetMapping("/{id}")
    public ResponseEntity<Integer> getStockById(@PathVariable int id) {
        int stock = bookStockService.getStockById(id);
        return new ResponseEntity<>(stock, HttpStatus.OK);
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
