package com.BookStore.App.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "line1")
    private String line1;

    @Column(name = "line2")
    private String line2;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "updated_by")
    private String updatedBy;

    public Address(String line1, String line2, String city, String pincode, String mobileNo) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.pincode = pincode;
        this.mobileNo = mobileNo;
    }

    public String getAddressString() {
        return "line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", pincode=" + pincode
                + ", mobileNo=" + mobileNo;
    }
}
