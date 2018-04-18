package com.liuhaozzu.datastructure.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringDemoTest {
	@Test
	public void testIndex() {
		StringDemo sDemo=new StringDemo();
		int index = sDemo.index("ababcd", "hgf", 0);
		assertEquals(-1, index);
		System.out.println(index);
		int index2 = sDemo.index("000001", "001", 0);
		//assertEquals(1, index);
		System.out.println(index2);
	}
}
