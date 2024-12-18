package com.BookStore.App.Controller.POJO;

  
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
	
public class UserResponse {
 
	private int id;
	
	private String firstName;
	
	private String lastName;
    
	private String email;
	
    

}
