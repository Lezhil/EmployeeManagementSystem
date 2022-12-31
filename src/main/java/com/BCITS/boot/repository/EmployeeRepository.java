package com.BCITS.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BCITS.boot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
							
}
