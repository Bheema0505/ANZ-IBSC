package com.infy.ibsc.util;

public class InvalidSessionException extends ValidationFailedException {

	public InvalidSessionException(String code, String message) {
		super(code, message);
	}

}
