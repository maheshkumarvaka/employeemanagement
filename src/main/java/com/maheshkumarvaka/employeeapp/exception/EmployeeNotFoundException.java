package com.maheshkumarvaka.employeeapp.exception;

public class EmployeeNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(Integer id)
	{		
		super("No employee found with the id:"+ id);		
	}
}
