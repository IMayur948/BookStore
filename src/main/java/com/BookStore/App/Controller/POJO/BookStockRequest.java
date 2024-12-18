package com.BookStore.App.Controller.POJO;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookStockRequest {
    
	@NotNull 
    private int bookId;
    
	@NotNull 
	private int stockIn;
    
	@NotNull 
	private int stockOut;
 
    
    public BookStockRequest() {}

    public BookStockRequest(int bookId, int stockIn, int stockOut) {
        this.bookId = bookId;
        this.stockIn = stockIn;
        this.stockOut = stockOut;
    } 
    
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getStockIn() {
        return stockIn;
    }

    public void setStockIn(int stockIn) {
        this.stockIn = stockIn;
    }

    public int getStockOut() {
        return stockOut;
    }

    public void setStockOut(int stockOut) {
        this.stockOut = stockOut;
    }

    @Override
    public String toString() {
        return "BookStockBean{" +
                 ", bookId=" + bookId +
                ", stockIn=" + stockIn +
                ", stockOut=" + stockOut +
                '}';
    }
}
