package com.maheshkumarvaka.employeeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maheshkumarvaka.employeeapp.entity.Employee;
import com.maheshkumarvaka.employeeapp.service.EmployeeService;

@RestController
@RequestMapping("/apis")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getEmp/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployee(id),HttpStatus.OK);
	}
	
	@PostMapping("/saveEmp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);				
	}		
	
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);	
		return new ResponseEntity<String>("Employee with the id "+ id +" deleted successfully",HttpStatus.OK);
	}

	@PutMapping("/updateEmp/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee,@PathVariable("id") Integer id) {
		employeeService.updateEmployee(employee,id);
		return new ResponseEntity<String>("Employee with the id "+ id +" details updated successfully",HttpStatus.OK);
	}
}
