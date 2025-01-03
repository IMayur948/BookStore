package com.BookStore.App.Controller.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookStockResponse {
    
    private int id;
    private int bookId;
    private int stockIn;
    private int stockOut;


}
