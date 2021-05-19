package com.ss.training.w1.d5.lambdas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.training.w1.d5.lambdas.W1D5Lambda2;

public class Lambda2Test {
	
	W1D5Lambda2 assign = new W1D5Lambda2();
	
	@Test
	public void assembleTest() {
		int[] input = {102, 1, 3002, 101, 2, 3001};
		String[] output = assign.assemble(input);
		
		assertEquals(output[0], "e102");
		assertEquals(output[1], "o1");
		assertEquals(output[2], "e3002");
		assertEquals(output[3], "o101");
		assertEquals(output[4], "e2");
		assertEquals(output[5], "o3001");
	}
	
}
