package com.maheshkumarvaka.employeeapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalException {
	@ExceptionHandler
	public ResponseEntity<?> handleEmployeeNotFoundException(EmployeeNotFoundException noempexception)	
	{
		return new ResponseEntity(noempexception.getMessage(),HttpStatus.NOT_FOUND);
		
	}
}
