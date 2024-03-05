package com.app.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class BankAccountVO {
	

	
	@NotEmpty(message="To Create bank account name is mandatory")
	private String name;
	
	@Min(1)
	@Max(49999 )
	private Long balance;
	
	@Pattern(regexp = "^.{10}$",message = "Invalid Mobile Number")
	private String mobileNumber;
	
	public BankAccountVO() {
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
		return "BankAccountVO [name=" + name + ", balance=" + balance + ", mobileNumber=" + mobileNumber + "]";
	}
	


}
