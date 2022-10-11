package com.siva.expensetrackerapi.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1414741908377044868L;
	
	
	public ResourceNotFoundException() {
		
	}
	
	public ResourceNotFoundException(String message){
		super(message);
	}

}
