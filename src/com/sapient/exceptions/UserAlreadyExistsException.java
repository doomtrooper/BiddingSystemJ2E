package com.sapient.exceptions;

public class UserAlreadyExistsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException(String str){
		System.out.println(str);
	}
}
