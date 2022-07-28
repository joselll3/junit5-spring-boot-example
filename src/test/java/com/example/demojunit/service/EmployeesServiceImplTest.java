package com.example.demojunit.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demojunit.domain.Employee;
import com.example.demojunit.repository.EmployeesRepository;

@ExtendWith(MockitoExtension.class)
class EmployeesServiceImplTest {

	@Mock
	private EmployeesRepository employeesRepository;
	
	@Mock
	private AgeHelperImpl ageHelper;
	
	@InjectMocks
	private EmployeesServiceImpl employeesService;
	
	
	@Test
	void when_minAgeIsNull_expect_allEmployees() {
		
		Employee employee = new Employee("Marta", LocalDate.of(2000, 1, 10));
		Mockito.when(employeesRepository.findAll()).thenReturn(Arrays.asList(employee));
		
		List<Employee> results = employeesService.find(null);
		
		Assertions.assertNotNull(results);
		Assertions.assertEquals(1, results.size());
		Assertions.assertEquals("Marta", results.get(0).getName());
	}

	@Test
	void when_minAge_expect_employeersUpAge() {
		
		Employee employee = new Employee("Marta", LocalDate.of(2000, 1, 10));
		Employee employeeJose = new Employee("Jose", LocalDate.of(1984, 10, 23));	
		Mockito.when(ageHelper.ageFromBirthDate(Mockito.any())).thenCallRealMethod();
		Mockito.when(employeesRepository.findAll()).thenReturn(Arrays.asList(employee, employeeJose));
		
		List<Employee> results = employeesService.find(30);
		
		Assertions.assertNotNull(results);
		Assertions.assertEquals(1, results.size());
		Assertions.assertEquals("Jose", results.get(0).getName());
		
	}
}
