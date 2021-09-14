package com.maheshkumarvaka.employeeapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException noempexception)	
	{
		return new ResponseEntity<>(noempexception.getMessage(),HttpStatus.NOT_FOUND);		
	}
	
	@ExceptionHandler(NullValueException.class)
	public ResponseEntity<String> handleNullValueException(NullValueException nullexception)	
	{
		return new ResponseEntity<>(nullexception.getMessage(),HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleAllExceptions(RuntimeException exception)	
	{
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);		
	}
}
