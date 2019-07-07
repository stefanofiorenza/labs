package com.knits.tms.exceptions;

public class ServiceException extends TmsException{
	
	public ServiceException(String message){
		super(message);
	}
	
	public ServiceException(Exception e){
		super(e);
	}
}
