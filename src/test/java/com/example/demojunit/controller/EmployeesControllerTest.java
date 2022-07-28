package com.example.demojunit.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MimeTypeUtils;

import com.example.demojunit.domain.Employee;
import com.example.demojunit.service.EmployeesService;

@WebMvcTest(EmployeesController.class)
class EmployeesControllerTest {

	@MockBean
	private EmployeesService service;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void when_callEmployersWithMinAgeNull_expect_all() throws Exception {
		
		Employee e1 = new Employee("Nati", LocalDate.of(1975, 1, 8));
		Mockito.when(service.find(null)).thenReturn(Arrays.asList(e1));
		
		this.mockMvc.perform(get("/employees"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MimeTypeUtils.APPLICATION_JSON_VALUE))
		.andExpect(content().json("[{'name':'Nati','bithDate':'1975-01-08'}]"));

	}
	
	@Test
	public void when_callInvalidEmpoint_expect_notFound() throws Exception {
		
		this.mockMvc.perform(get("/notfound"))
		.andExpect(status().is4xxClientError());
		
	}
	
}
