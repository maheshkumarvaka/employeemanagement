package com.maheshkumarvaka.employeeapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maheshkumarvaka.employeeapp.entity.Employee;
import com.maheshkumarvaka.employeeapp.repository.EmployeeRepository;
import com.maheshkumarvaka.employeeapp.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}


	@Override
	public Employee getEmployee(Integer id) {
		Optional<Employee> emp= employeeRepository.findById(id);
		return emp.isPresent()?emp.get():null;
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}
