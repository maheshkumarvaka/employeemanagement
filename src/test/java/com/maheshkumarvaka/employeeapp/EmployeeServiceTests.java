package com.maheshkumarvaka.employeeapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.maheshkumarvaka.employeeapp.entity.Department;
import com.maheshkumarvaka.employeeapp.entity.Employee;
import com.maheshkumarvaka.employeeapp.repository.EmployeeRepository;
import com.maheshkumarvaka.employeeapp.service.impl.EmployeeServiceImpl;
@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeServiceTests {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	
		@Test
		public void getAllEmployeesTest()
	    {
			Department dept=new Department(3,"admin","Other","Other",new Date());
	        List<Employee> list = new ArrayList<Employee>();
	        Employee empOne = new Employee(882, "John", "john@1234","john@evoketechnologies.com", BigInteger.valueOf(87980989765L),dept,"admin",new Date());
	        Employee empTwo = new Employee(883, "Kevin", "kevin@1234","kevin@evoketechnologies.com", BigInteger.valueOf(87980989766L),dept,"admin",new Date());
	        Employee empThree = new Employee(884, "Roston", "roston@1234","roston@evoketechnologies.com", BigInteger.valueOf(87980989365L),dept,"admin",new Date());
	         
	        list.add(empOne);
	        list.add(empTwo);
	        list.add(empThree);
	    
	   when(employeeRepository.findAll()).thenReturn(list);
	        	         
        assertEquals(3, employeeServiceImpl.getAllEmployees().size());
        }
		
		@Test
		public void getEmployeeById() {
			Integer id=882;
			Department dept=new Department(3,"admin","Other","Other",new Date());
			Optional<Employee> example=Optional.of(new Employee(882, "John", "john@1234","john@evoketechnologies.com",
					BigInteger.valueOf(87980989765L),dept,"admin",new Date()));
			when(employeeRepository.findById(id)).
			thenReturn(example);
			
			assertEquals("john@evoketechnologies.com",employeeServiceImpl.getEmployee(id).getEmail());
		}
		
		@Test
		public void saveEmployee() {
			Department dept=new Department(3,"admin","Other","Other",new Date());
			Employee sample = new Employee(882, "John", "john@1234","john@evoketechnologies.com", BigInteger.valueOf(87980989765L),dept,"admin",new Date());
	        when(employeeRepository.save(sample)).thenReturn(sample);
	        assertEquals(sample,employeeServiceImpl.saveEmployee(sample));
		}
		
		
}
