package com.project.CarRentalService.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cusId;
	private String name;
	private String mobileNo;
	private String email;
	private String city;
	private String state;
	private long pincode;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date pickupDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date returnDate;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String city, Long cusId, String email, String mobileNo, String name, Date pickupDate, long pincode, Date returnDate, String state) {
		this.city = city;
		this.cusId = cusId;
		this.email = email;
		this.mobileNo = mobileNo;
		this.name = name;
		this.pickupDate = pickupDate;
		this.pincode = pincode;
		this.returnDate = returnDate;
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getCusId() {
		return cusId;
	}

	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
