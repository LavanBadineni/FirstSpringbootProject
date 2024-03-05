package com.app.advice;

public class ErrorVO {
	
	
	private String errorMessage;
	private Integer errorCode;
	public ErrorVO(String errorMessage, Integer errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	public ErrorVO() {
		super();
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	
	@Override
	public String toString() {
		return "ErrorVO [errorMessage=" + errorMessage + ", errorCode=" + errorCode + "]";
	}
	
	
}
