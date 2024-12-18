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
public class BookRequest {
	
	@NotNull
    private String title;
    
	@NotNull
	private int authorId;
    
	@NotNull
	private int publisherId; 
     
}
