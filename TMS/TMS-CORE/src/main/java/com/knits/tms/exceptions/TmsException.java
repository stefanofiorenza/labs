package com.knits.tms.exceptions;

import lombok.Getter;
import lombok.Setter;

public class TmsException extends RuntimeException{

	@Getter
	@Setter
	int code;
	
	public TmsException(String message){
		super(message);
	}
	
	public TmsException(Exception e){
		super(e);
	}
}
