package com.example.demojunit.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

@Component
public class AgeHelperImpl implements AgeHelper {

	@Override
	public Integer ageFromBirthDate(LocalDate birthDate) {
		if(birthDate == null) {
			throw new IllegalArgumentException("'birthDate' is mandatory");
		}
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

}
