package com.example.demojunit.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AgeHelperImplTest {

	private AgeHelperImpl ageHelper = new AgeHelperImpl();
	
	@Test
	void when_birthDate_expect_validAge() {
		LocalDate myBirthDate = LocalDate.of(1984, 10, 23);
		
		Integer age = ageHelper.ageFromBirthDate(myBirthDate);
		
		assertEquals(37, age);
		
	}
	
	@Test
	void when_nullBirthDate_expect_illegalArgumentException() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> ageHelper.ageFromBirthDate(null));
	}

}
