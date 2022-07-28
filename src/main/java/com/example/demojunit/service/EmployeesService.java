package com.example.demojunit.service;

import java.util.List;

import com.example.demojunit.domain.Employee;

public interface EmployeesService {
	
	List<Employee> find(Integer minAge);

}
