package com.springboot.validationandexception.exception;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException(String message) {
		super(message);
	}

}
