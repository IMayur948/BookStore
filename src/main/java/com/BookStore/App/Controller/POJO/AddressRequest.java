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
    
    @Size(min = 1, max = 100 )
    private String line2;
    
    @NotNull
    @Size(min = 1, max = 50 )
    private String city;
    
    @NotNull 
    @Size(min = 1, max = 20)
    private String pincode;
    
    @NotNull
    @Size(min = 10, max = 15)
    private String mobileNo;
    
    public AddressRequest() {}

    public AddressRequest(String line1, String line2, String city, String pincode, String mobileNo) {
 		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

  
    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

 
    
    
}
