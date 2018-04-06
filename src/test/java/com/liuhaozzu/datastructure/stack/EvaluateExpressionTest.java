package com.liuhaozzu.datastructure.stack;

import org.junit.Test;

public class EvaluateExpressionTest {

	@Test
	public void testEvaluate() {
		EvaluateExpression ee= new EvaluateExpression();
		int result = ee.evaluate("3*(7-2)");
		System.out.println(result);
	}
}
