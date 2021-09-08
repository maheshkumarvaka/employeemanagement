package com.maheshkumarvaka.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maheshkumarvaka.employeeapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
