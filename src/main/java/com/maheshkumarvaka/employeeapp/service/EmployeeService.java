package com.maheshkumarvaka.employeeapp.service;

import java.util.List;

import com.maheshkumarvaka.employeeapp.entity.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	Employee getEmployee(Integer id);
	List<Employee> getAllEmployees();
	void deleteEmployee(Integer id);
	void updateEmployee(Employee employee,Integer id);
}
