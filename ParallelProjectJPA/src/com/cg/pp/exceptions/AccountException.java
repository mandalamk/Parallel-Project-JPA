package com.cg.pp.exceptions;

public class AccountException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AccountException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AccountException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public AccountException() {
		// TODO Auto-generated constructor stub
	}

}
