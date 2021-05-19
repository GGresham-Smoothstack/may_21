package com.ss.training.w1.d5.datetime.test;

import static org.junit.Assert.assertEquals;

import java.time.YearMonth;

import org.junit.Test;

import com.ss.training.w1.d5.datetime.W1D5Datetime6;

public class Datetime6Test {
	
	W1D5Datetime6 assign = new W1D5Datetime6();
	
	@Test
	public void getMondaysTest() {
		YearMonth input = YearMonth.of(2021, 5);
		int[] mondays = assign.getMondays(input);
		
		assertEquals(mondays[0], 3);
		assertEquals(mondays[1], 10);
		assertEquals(mondays[2], 17);
		assertEquals(mondays[3], 24);
		assertEquals(mondays[4], 31);
		
	}
	
}
