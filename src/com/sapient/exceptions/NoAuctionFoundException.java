package com.sapient.exceptions;

public class NoAuctionFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoAuctionFoundException(String str){
		System.out.println(str);
	}
}
