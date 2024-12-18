package com.BookStore.App.Controller.POJO;

import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherRequest {
	
	@NotNull
    @Size(min = 1, max = 100)
    private String firstName;
	
	@NotNull
    @Size(min = 1, max = 100)
    private String lastName;
	
	@NotNull
    private int addressId;

}
