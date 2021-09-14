package com.maheshkumarvaka.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maheshkumarvaka.employeeapp.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
