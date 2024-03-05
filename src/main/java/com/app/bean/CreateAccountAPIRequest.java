package com.app.bean;

public class CreateAccountAPIRequest {
	
	/*
	 * "name": "bandineni", "balance": 3000, "mobileNumber": "8744994884"
	 */

	
	private String name;
	private Long balance;
	private String mobileNumber;
	public CreateAccountAPIRequest() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "CreateAccountAPIRequest [name=" + name + ", balance=" + balance + ", mobileNumber=" + mobileNumber
				+ "]";
	}
	
	
	
	
}
