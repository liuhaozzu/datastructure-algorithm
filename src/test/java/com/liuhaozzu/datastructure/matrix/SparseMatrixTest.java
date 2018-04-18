package com.liuhaozzu.datastructure.matrix;

import org.junit.Before;
import org.junit.Test;

public class SparseMatrixTest {
	private SparseMatrix sm;
	
	
	@Before
	public void setup() {
		//int[][] matrix = new int[6][6];
		//sm=new SparseMatrix(matrix);
		Triple triple0=new Triple(1, 2, 12);
		Triple triple1=new Triple(1, 3, 9);
		Triple triple2=new Triple(3, 1, -3);
		Triple triple3=new Triple(3, 6, 14);
		Triple triple4=new Triple(4, 3, 24);
		Triple triple5=new Triple(5, 2, 8);
		Triple triple6=new Triple(6, 1, 15);
		Triple triple7=new Triple(6, 4, -7);
		Triple[] data = new Triple[] {triple0, triple1, triple2,triple3,triple4,triple5,triple6,triple7};
		sm= new SparseMatrix(data, 6, 7);
	}
	
	@Test
	public void testToString() {
		System.out.println(sm.toString());
		SparseMatrix transformed= sm.transposition();
		System.out.println(transformed.toString());
		SparseMatrix fastTransformed= sm.fastTransposition();
		System.out.println(fastTransformed.toString());
	}
	
	
}
