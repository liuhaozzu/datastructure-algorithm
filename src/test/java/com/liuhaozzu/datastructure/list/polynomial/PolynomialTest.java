package com.liuhaozzu.datastructure.list.polynomial;

import org.junit.Before;
import org.junit.Test;

public class PolynomialTest {

	private Polynomial polyn1;
	
	@Before
	public void setup() {
		polyn1= new Polynomial(1f, 2);
	}
	
	@Test
	public void testAddPolyn() {
		polyn1.addTerm(new Term(2f, 3));
		polyn1.addTerm(new Term(3f, 2));
		polyn1.addTerm(new Term(3f, 5));
		polyn1.addTerm(new Term(3f, 1));
		polyn1.printPolyn();
	}
}
