package com.maheshkumarvaka.employeeapp.exception;

public class NullValueException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public NullValueException()
	{		
		super("One or more employee input details are not provided/provided as null");		
	}
}

