package com.BCITS.boot.service;

import java.util.List;



import com.BCITS.boot.model.Employee;


public interface EmployeeService {
	
						List<Employee>getAllEmployees();
						void saveEmployee(Employee employee);
						Employee getEmployeeById(long id);
						void deleteEmployeeById(long id);
						
}
