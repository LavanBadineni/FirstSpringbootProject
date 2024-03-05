package com.app.bean;

public class BankAccountUpdateRequestVO {
	

	private Long bankAccountNumber;
	
	private String accountHolderName;
	
	private Long balance;
	
	
	private String mobileNumber;

	public BankAccountUpdateRequestVO() {
		super();
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
		return "BankAccountUpdateRequestVO [bankAccountNumber=" + bankAccountNumber + ", accountHolderName="
				+ accountHolderName + ", balance=" + balance + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
	
	

}
