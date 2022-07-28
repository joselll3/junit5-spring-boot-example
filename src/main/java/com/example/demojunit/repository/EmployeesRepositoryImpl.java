package com.example.demojunit.repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demojunit.domain.Employee;

@Repository
public class EmployeesRepositoryImpl implements EmployeesRepository {

	@Override
	public List<Employee> findAll() {
		Employee e1 = new Employee("Fran", LocalDate.of(2010, 1, 5));
		Employee e2 = new Employee("Marta", LocalDate.of(1984, 10, 23));
		Employee e3 = new Employee("Pedro", LocalDate.of(1981, 12, 18));
		Employee e4 = new Employee("Raquel", LocalDate.of(1990, 4, 16));
		Employee e5 = new Employee("Manuel", LocalDate.of(1988, 12, 5));
		return Arrays.asList(e1, e2, e3, e4, e5);
	}

}
