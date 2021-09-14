package com.maheshkumarvaka.employeeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maheshkumarvaka.employeeapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select empdept.name,empdept.createdOn,empdept.department.name from Employee empdept where empdept.id=?1")
	Object getEmployeeDept(Integer id);

	@Query("select count(emp),emp.department.id from Employee emp group by emp.department.id")
	List<Object> getEmployeeCountByDept();

}
