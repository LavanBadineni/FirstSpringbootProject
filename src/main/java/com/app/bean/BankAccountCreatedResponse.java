package com.app.bean;

public class BankAccountCreatedResponse {
	
	
   private String message;
   
   private Integer responseCode;
   
   private Long accountNumber;

public BankAccountCreatedResponse() {
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

public Long getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(Long accountNumber) {
	this.accountNumber = accountNumber;
}

@Override
public String toString() {
	return "BankAccountCreatedResponse [message=" + message + ", responseCode=" + responseCode + ", accountNumber="
			+ accountNumber + "]";
}
   
   

}
