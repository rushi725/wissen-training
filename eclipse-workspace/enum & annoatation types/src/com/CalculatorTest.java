package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	Calculator cal ;
	
	@Before
	public void setUpClass() {
		cal = new Calculator();
	}
	
	@Test
	public void add1() {
		int actual = cal.add(10,15);
		int expected = 25;
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void add2() {
		int actual = cal.add(10,15);
		int expected = 24;
		assertNotEquals(actual,expected);
		
	}
	
}



