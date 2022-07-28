package com.example.demojunit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demojunit.domain.Employee;
import com.example.demojunit.repository.EmployeesRepository;

@Service
public class EmployeesServiceImpl implements EmployeesService {
	
	@Autowired
	private EmployeesRepository employeesRepository;
	
	@Autowired
	private AgeHelper ageHelper;

	@Override
	public List<Employee> find(Integer minAge) {	
		
		if(minAge != null) {
			return employeesRepository.findAll().stream()
					.filter(e -> ageHelper.ageFromBirthDate(e.getBithDate()) >= minAge)
					.collect(Collectors.toList());
			
		}else {
			return employeesRepository.findAll();
		}
	}

}
