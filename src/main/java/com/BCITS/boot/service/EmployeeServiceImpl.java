package com.BCITS.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BCITS.boot.model.Employee;
import com.BCITS.boot.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	EmployeeRepository employeeRepositery;
	
	public List<Employee> getAllEmployees() {
		
		return employeeRepositery.findAll();
	}

	public void saveEmployee(Employee employee) {
		
		this.employeeRepositery.save(employee);
		
	}

	public Employee getEmployeeById(long id) {
		Optional <Employee> optional=employeeRepositery.findById(id);
		Employee employee=null;
		if(optional.isPresent()) {
			employee=optional.get();
		}
		else {
			
			throw new RuntimeException("Employee not found for id::"+id);
		}
		return employee;
	}

	public void deleteEmployeeById(long id) {
		this.employeeRepositery.deleteById(id);
		
	}

				
}
