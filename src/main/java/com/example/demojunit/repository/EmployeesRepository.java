package com.example.demojunit.repository;

import java.util.List;

import com.example.demojunit.domain.Employee;

public interface EmployeesRepository  {

	List<Employee> findAll();
}
