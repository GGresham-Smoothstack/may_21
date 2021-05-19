package com.ss.training.w1.d5.datetime.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import com.ss.training.w1.d5.datetime.W1D5Datetime7;

public class Datetime7Test {
	
	W1D5Datetime7 assign = new W1D5Datetime7();
	
	@Test
	public void onFridayTheThirteenthTest() {
		LocalDate input = LocalDate.of(2021, 5, 19);
		LocalDate input2 = LocalDate.of(2021, 5, 14);
		LocalDate input3 = LocalDate.of(2020, 11, 13);
		LocalDate input4 = LocalDate.of(2020, 12, 13);
		LocalDate input5 = LocalDate.of(2020, 11, 20);
		
		assertEquals(assign.onFridayTheThirteenth(input), false);
		assertEquals(assign.onFridayTheThirteenth(input2), false);
		assertEquals(assign.onFridayTheThirteenth(input3), true);
		assertEquals(assign.onFridayTheThirteenth(input4), false);
		assertEquals(assign.onFridayTheThirteenth(input5), false);
		
	}
	
}
