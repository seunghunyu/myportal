package com.bitacademy.myportal.exception;

public class DaoException extends RuntimeException {
	public DaoException() {
		super("DaoException 발생");
	}
	
	public DaoException(String message) {
		super(message);
	}
}
