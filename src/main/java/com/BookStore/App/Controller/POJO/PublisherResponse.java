package com.BookStore.App.Controller.POJO;

 
import com.BookStore.App.Model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherResponse {
	
	private int id;
	private String firstName; 
    private String lastName;
    private String address;

}
