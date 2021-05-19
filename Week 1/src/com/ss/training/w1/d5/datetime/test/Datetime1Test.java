package com.ss.training.w1.d5.datetime.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import com.ss.training.w1.d5.datetime.W1D5Datetime1;

public class Datetime1Test {
	
	W1D5Datetime1 assign = new W1D5Datetime1();
	
	@Test
	public void birthdayTest() {
		LocalDate bdayExample = assign.birthday(1990, 1, 1);
		
		assertEquals(bdayExample.toString(), "1990-01-01");
	}
	
}
