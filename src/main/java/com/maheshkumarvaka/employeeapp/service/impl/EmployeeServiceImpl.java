package com.maheshkumarvaka.employeeapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maheshkumarvaka.employeeapp.entity.Employee;
import com.maheshkumarvaka.employeeapp.exception.EmployeeNotFoundException;
import com.maheshkumarvaka.employeeapp.repository.EmployeeRepository;
import com.maheshkumarvaka.employeeapp.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
		
	@Override
	public Employee saveEmployee(Employee employee) {		
		return employeeRepository.save(employee);
	}


	@Override
	public Employee getEmployee(Integer id) {
		
		return employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));		
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}


	@Override
	public void deleteEmployee(Integer id) {
		if(idCheck(id))
			employeeRepository.deleteById(id);
		else
			throw new EmployeeNotFoundException(id);
			}
	
	public boolean idCheck(Integer id) {
		return employeeRepository.findById(id).isPresent();
	}


	@Override
	public void updateEmployee(Employee employee, Integer id) {		
		if(idCheck(id)) {			
			Employee updatedEmployee=employeeRepository.save(employee);
		}
		else
			throw new EmployeeNotFoundException(id);
		
	}

}
