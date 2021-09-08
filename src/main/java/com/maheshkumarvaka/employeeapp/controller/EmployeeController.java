package com.maheshkumarvaka.employeeapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maheshkumarvaka.employeeapp.entity.Employee;
import com.maheshkumarvaka.employeeapp.service.EmployeeService;

@RestController
@RequestMapping("/apis")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getEmp/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployee(id),HttpStatus.OK);
	}
	
	@PostMapping("/saveEmp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		//System.out.println(employee.getPhone());
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);				
	}
	
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	
}
