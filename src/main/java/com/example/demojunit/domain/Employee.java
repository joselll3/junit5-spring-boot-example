package com.example.demojunit.domain;

import java.time.LocalDate;

public class Employee {
	
	private String name;
	
	private LocalDate bithDate;
	
	
	public Employee(String name, LocalDate bithDate) {
		super();
		this.name = name;
		this.bithDate = bithDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBithDate() {
		return bithDate;
	}

	public void setBithDate(LocalDate bithDate) {
		this.bithDate = bithDate;
	}

}
