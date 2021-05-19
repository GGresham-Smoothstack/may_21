package com.ss.training.w1.d5.datetime.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import com.ss.training.w1.d5.datetime.W1D5Datetime2;
public class Datetime2Test {
	
	W1D5Datetime2 assign = new W1D5Datetime2();
	
	@Test
	public void lastThursdayTest() {
		LocalDate input = LocalDate.of(2021, 5, 19);
		LocalDate lastThursday = assign.lastThursday(input);
		
		assertEquals(lastThursday.toString(), "2021-05-13");
	}
	
}
