package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long bankAccountNumber;
	private String accountHolderName;
	private String mobileNumber;
	private Long balance;
	
	
	public BankAccount() {
		super();
	}


	public BankAccount(Long bankAccountNumber, String accountHolderName, String mobileNumber, Long balance) {
		super();
		this.bankAccountNumber = bankAccountNumber;
		this.accountHolderName = accountHolderName;
		this.mobileNumber = mobileNumber;
		this.balance = balance;
	}


	public Long getBankAccountNumber() {
		return bankAccountNumber;
	}


	public void setBankAccountNumber(Long bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}


	public String getAccountHolderName() {
		return accountHolderName;
	}


	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public Long getBalance() {
		return balance;
	}


	public void setBalance(Long balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "BankAccount [bankAccountNumber=" + bankAccountNumber + ", accountHolderName=" + accountHolderName
				+ ", mobileNumber=" + mobileNumber + ", balance=" + balance + "]";
	}
	
	

}
