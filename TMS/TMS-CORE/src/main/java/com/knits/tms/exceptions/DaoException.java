package com.knits.tms.exceptions;

public class DaoException extends ServiceException{

	public DaoException (String message){
		super(message);
	}
	
	public DaoException (Exception rootException){
		super(rootException);
	}
}
