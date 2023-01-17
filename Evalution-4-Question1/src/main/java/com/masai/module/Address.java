package com.masai.module;

import javax.persistence.Column;

public class Address {
	
	@Column(length = 6)
	private String pincode;
	private String state;
	private String city;
	
	public Address(String pincode, String state, String city) {
		super();
		this.pincode = pincode;
		this.state = state;
		this.city = city;
	}
	
	public Address() {
		super();
	}
	
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Address [pincode=" + pincode + ", state=" + state + ", city=" + city + "]";
	}
	
}
