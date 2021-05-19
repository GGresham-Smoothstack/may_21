package com.ss.training.w1.d5.datetime.test;

import static org.junit.Assert.assertEquals;

import java.time.Instant;

import org.junit.Test;

import com.ss.training.w1.d5.datetime.W1D5Datetime4;

public class Datetime4Test {
	
	W1D5Datetime4 assign = new W1D5Datetime4();
	
	@Test
	public void conversionTest() {
		Instant input = Instant.now();
		Instant output = assign.conversion(input);
		
		assertEquals((output instanceof Instant), true);
	}
	
}
