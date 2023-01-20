package com.infy.ibsc.util;

public class ServiceException extends Exception {
	
	public String code;

	public ServiceException(String code, String message) {
		super(message);
		this.code = code;
	}

	@Override
	public String getMessage() {
		return this.code+": "+super.getMessage();
	}

	
}
