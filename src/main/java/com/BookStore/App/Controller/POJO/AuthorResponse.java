package com.BookStore.App.Controller.POJO;

 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse {
	
	private int id;
    private String firstName;
    private String lastName;
    private int address; 

    public AuthorResponse() {}

    public AuthorResponse(int id, String firstName, String lastName, int address) {
        this.id = id;
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
    

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
    public String toString() {
        return "AuthorBean{" +
        		"id= '" + id + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressId=" + address+
                '}';
    }
}
