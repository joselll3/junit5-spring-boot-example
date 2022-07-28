package com.example.demojunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojunit.domain.Employee;
import com.example.demojunit.service.EmployeesService;

@RestController
public class EmployeesController {

	@Autowired
	private EmployeesService employeesService;
	
	@GetMapping("/employees")
	public List<Employee> find(@RequestParam(required=false) Integer minAge) {
		return employeesService.find(minAge);
	}
}

