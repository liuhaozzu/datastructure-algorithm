package com.liuhaozzu.datastructure.stack.recursion;

import org.junit.Test;

import com.liuhaozzu.datastructure.stack.recursion.Hanoi;

public class HanoiTest {

	@Test
	public void testHanoi() {
		Hanoi hanoi = new Hanoi();
		hanoi.hanoi(3, 'X', 'Y', 'Z');
	}
}
