package com.ss.training.w1.d5.lambdas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.training.w1.d5.lambdas.W1D5Lambda3;

public class Lambda3Test {
	
	W1D5Lambda3 assign = new W1D5Lambda3();
	
	@Test
	public void assembleTest() {
		String[] input = {"abc", "abcd", "cba", "cab", "a", "aaa", "zyx"};
		String[] output = assign.filter(input);
		
		assertEquals(output[0], "abc");
		assertEquals(output[1], "aaa");
	}
	
}
