package com.sapient.exceptions;

public class NoItemFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoItemFoundException(String str){
		System.out.println(str);
	}
}
