package com.BookStore.App.Controller.POJO;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
 
@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddressRequest {

	@NotNull
    @Size(min = 1, max = 100)
    private String line1;
    
    @Size(min = 1, max = 100)
    private String line2;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String city;
    
    @NotNull 
    @Size(min = 1, max = 20)
    private String pincode;
    
    @NotNull
    @Size(min = 10, max = 15)
    private String mobileNo;
}
