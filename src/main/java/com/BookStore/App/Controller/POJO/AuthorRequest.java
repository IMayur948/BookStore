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
public class AuthorRequest {

	@NotNull
    @Size(min = 1, max = 100)
    private String firstName;
	
	@NotNull
    @Size(min = 1, max = 100)
    private String lastName;
	
	@NotNull 
	private int address; 

    public AuthorRequest() {}

    public AuthorRequest(String firstName, String lastName, int address) {
    	this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address= address;
    }
    

 
	@Override
    public String toString() {
        return "AuthorBean{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressId=" + address+
                '}';
    }
}
