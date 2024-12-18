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
  
}
