package com.ss.training.w1.d5.lambdas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.training.w1.d5.lambdas.W1D5Lambda1;

public class Lambda1Test {
	
	W1D5Lambda1 assign = new W1D5Lambda1();
	
	
	@Test
	public void lengthTest() {
		String[] input = {"12345", "123", "1"};
		String[] output = assign.length(input);
		
		assertEquals(output[0], "1");
		assertEquals(output[1], "123");
		assertEquals(output[2], "12345");
	}
	
	@Test
	public void reverseLengthTest() {
		String[] input = {"1", "123", "12345"};
		String[] output = assign.reverseLength(input);
		
		assertEquals(output[0], "12345");
		assertEquals(output[1], "123");
		assertEquals(output[2], "1");
	}
	
	@Test
	public void alphaTest() {
		String[] input = {"A", "Ba", "AAz"};
		String[] output = assign.alpha(input);
		
		assertEquals(output[0], "A");
		assertEquals(output[1], "AAz");
		assertEquals(output[2], "Ba");
	}
	
	//Making sure that the alphabetical sort functions only via the first letter
	@Test
	public void alphaFirstOnlyTest() {
		String[] input = {"AB", "AAz", "AAA"};
		String[] output = assign.alpha(input);
		
		assertEquals(output[0], "AB");
		assertEquals(output[1], "AAz");
		assertEquals(output[2], "AAA");
	}
	
	@Test
	public void eTest() {
		String[] input = {"Phon", "ePhon", "e"};
		String[] output = assign.e(input);
		
		assertEquals(output[0], "ePhon");
		assertEquals(output[1], "e");
		assertEquals(output[2], "Phon");
	}
	
}
