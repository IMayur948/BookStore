package com.BookStore.App.Controller.POJO;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
	
	@NotNull 
    private String firstName;
	
	@NotNull
	private String lastName;
    
	@NotNull
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid Email Format")
	private String email;
    
//    @NotNull
//    @Pattern(regexp = "[a-zA-Z]+")
//    private String role;
//    
    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$", message = "Password must contain at least one digit, one lowercase ,one uppercase, and one special character")
    private String password;
   
}

