package com.ss.training.w1.d4.a4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LineTest {
	
	Line l = new Line(0, 0, 1, 1);
	Line l2 = new Line(0, 0, 2, 1);
	Line l3 = new Line(0, 0, 1, 2);
	Line l4 = new Line(1, 1, 2, 2);
	Line l5 = new Line(1, 1, 3, 2);
	
	@Test
	public void getSlopeTest() {
		assertEquals(1, l.getSlope(), 0.001);
		assertEquals(0.5, l2.getSlope(), 0.001);
		assertEquals(2, l3.getSlope(), 0.001);
		assertEquals(1, l4.getSlope(), 0.001);
		assertEquals(0.5, l5.getSlope(), 0.001);
	}
	
	@Test
	public void getDistanceTest() {
		assertEquals(1.4142135623731, l.getDistance(), 0.001);
		assertEquals(2.2360679775, l2.getDistance(), 0.001);
		assertEquals(2.2360679775, l3.getDistance(), 0.001);
		assertEquals(1.4142135623731, l4.getDistance(), 0.001);
		assertEquals(2.2360679775, l5.getDistance(), 0.001);
	}
	
	@Test
	public void parallelToTest() {
		assertTrue(l.parallelTo(l4));
		assertTrue(l2.parallelTo(l5));
		assertFalse(l.parallelTo(l3));
	}

}
