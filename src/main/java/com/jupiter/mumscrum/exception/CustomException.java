package com.jupiter.mumscrum.exception;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String errCode;
	private String errMessage;
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	
	public CustomException(String errCode, String errMessage) {
		this.errCode = errCode;
		this.errMessage = errMessage;
	}
}
