package com.BookStore.App.Controller.POJO;

 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherResponse {
	
	private int id;
	private String firsName; 
    private String lastName;
    private int address;

    public PublisherResponse() {}

    public PublisherResponse(int id, String firstName, String lastName, int address) {
        this.id = id;
    	this.firsName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    
    
 
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


    public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
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
        this.address = address;
    }

    @Override
    public String toString() {
        return "PublisherBean{" +
                 "name='" + firsName + '\'' +
                ", contact='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
