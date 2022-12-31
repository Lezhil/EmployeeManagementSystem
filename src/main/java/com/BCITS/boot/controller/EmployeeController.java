package com.BCITS.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.BCITS.boot.model.Employee;
import com.BCITS.boot.service.EmployeeService;

@Controller
public class EmployeeController {
			
				@SuppressWarnings("unused")
				@Autowired
				private EmployeeService employeeService;
				
				
				@SuppressWarnings("unused")
				@GetMapping("/")
				private String viewHomePage(Model model) {
					
					model.addAttribute("listEmployees",employeeService.getAllEmployees());
					return "index";
				}
				
				@GetMapping("/showNewEmployeeForm")
				private String showNewEmployeeForm(Model model) {
					
					 // create model attribute to bind form data
					Employee employee= new Employee();
					model.addAttribute("employee",employee);
					return "new_employee";
					
				}
				@PostMapping("/saveEmployee")
				private String saveEmployee(@ModelAttribute("employee")Employee employee) {
					
				     // save employee to database
					
					employeeService.saveEmployee(employee);
					return "redirect:/";
				}
				
				@GetMapping("/showFormUpdate/{id}")
				private String showFormUpdate(@PathVariable(value="id")long id,Model model) {
					
					
					Employee employee= employeeService.getEmployeeById(id);
					model.addAttribute("employee",employee);
					return "update_employee";
					
				}
				
				@GetMapping("/DeleteEmployee/{id}")
				public String deleteEmployee(@PathVariable(value="id")long id) {

				
			        // call delete employee method
					this.employeeService.deleteEmployeeById(id);
					return "redirect:/";
				}
}
