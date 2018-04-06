package com.liuhaozzu.datastructure.stack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NumberConverterTest {
	
	private NumberConverter converter;
	@Before
	public void setup() {
		converter=new NumberConverter();
	}

	@Test
	public void testDec2Oct() {
		String target = converter.dec2Oct(1348);
		assertEquals("2504", target);
	}
}
