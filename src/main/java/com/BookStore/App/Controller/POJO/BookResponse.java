package com.BookStore.App.Controller.POJO;
 
import com.BookStore.App.Model.Author;
import com.BookStore.App.Model.Publisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private int id;   
    private String title;
    private String author;
    private String publisher;
    
}
