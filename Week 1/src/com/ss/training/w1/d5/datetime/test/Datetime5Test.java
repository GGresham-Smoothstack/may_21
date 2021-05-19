package com.ss.training.w1.d5.datetime.test;

import static org.junit.Assert.assertEquals;

import java.time.YearMonth;

import org.junit.Test;

import com.ss.training.w1.d5.datetime.W1D5Datetime5;

public class Datetime5Test {
	
	W1D5Datetime5 assign = new W1D5Datetime5();
	
	@Test
	public void getMonthsTest() {
		YearMonth[] months = assign.getMonths(2021);
		
		assertEquals(months[0].lengthOfMonth(), 31);
		assertEquals(months[1].lengthOfMonth(), 28);
		assertEquals(months[2].lengthOfMonth(), 31);
		assertEquals(months[3].lengthOfMonth(), 30);
		assertEquals(months[4].lengthOfMonth(), 31);
		assertEquals(months[5].lengthOfMonth(), 30);
		assertEquals(months[6].lengthOfMonth(), 31);
		assertEquals(months[7].lengthOfMonth(), 31);
		assertEquals(months[8].lengthOfMonth(), 30);
		assertEquals(months[9].lengthOfMonth(), 31);
		assertEquals(months[10].lengthOfMonth(), 30);
		assertEquals(months[11].lengthOfMonth(), 31);
	}
	
}
