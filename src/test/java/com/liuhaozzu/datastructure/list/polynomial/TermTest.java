package com.liuhaozzu.datastructure.list.polynomial;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TermTest {

	@Test
	public void toStringTest() {
		Term term= new Term(3,2);
		assertEquals("3.0*x^2", term.toString());
	}
}
