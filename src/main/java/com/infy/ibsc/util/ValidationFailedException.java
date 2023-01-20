package com.infy.ibsc.util;

public class ValidationFailedException extends Exception {
	
	public String code;

	public ValidationFailedException(String code, String message) {
		super(message);
		this.code = code;
	}

	@Override
	public String getMessage() {
		return this.code+": "+super.getMessage();
	}

	
}
