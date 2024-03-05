package com.app.bean;

public class CreateAccountAPIResponse {
	
	private String message;
	private Integer responseCode;
	private String accountNumber;
	public CreateAccountAPIResponse() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Override
	public String toString() {
		return "CreateAccountAPIResponse [message=" + message + ", responseCode=" + responseCode + ", accountNumber="
				+ accountNumber + "]";
	}
	
	
	

}
