package com.sapient.exceptions;

public class NoBidFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoBidFoundException(String str){
		System.out.println(str);
	}
}
