package com.wipro.customexception;


public class BOOKING_NOT_FOUND_EXCEPTION extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public BOOKING_NOT_FOUND_EXCEPTION(String message) {
		super(message);
	}
}
