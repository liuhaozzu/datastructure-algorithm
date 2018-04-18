package com.liuhaozzu.datastructure.matrix;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.Arrays;

public class SparseMatrix {

	private Triple[] data;
	private int rows;
	private int cols;
	private int[][] matrix;

	public SparseMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public SparseMatrix(Triple[] data, int rows, int cols) {
		super();
		this.data = data;
		this.rows = rows;
		this.cols = cols;
		this.matrix = new int[rows][cols];
		for (int i = 0; i < data.length; i++) {
			int row = data[i].getRow();
			int col = data[i].getCol();
			int value = data[i].getValue();
			matrix[row - 1][col - 1] = value;
		}
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public Triple[] getData() {
		return data;
	}

	public void setData(Triple[] data) {
		this.data = data;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public SparseMatrix transposition() {
		if (matrix == null) {
			return null;
		}
		int q = 0;
		int count = 0;
		Triple[] transformed = new Triple[data.length];
		for (int col = 0; col < this.getCols(); col++) {
			for (int i = 0; i < data.length; i++) {
				if (data[i].getCol() == col) {
					transformed[q] = new Triple(data[i].getCol(), data[i].getRow(), data[i].getValue());
					q++;
					count++;
				}
			}
		}
		System.out.println("时间复杂度：" + count);
		return new SparseMatrix(transformed, cols, rows);
	}

	public SparseMatrix fastTransposition() {
		if (matrix == null) {
			return null;
		}
		int count = 0;
		Triple[] transformed = new Triple[data.length];
		int[] num = new int[this.getCols()];
		int[] cpot = new int[this.getCols()];
		cpot[0] = 0;
		for (int i = 0; i < data.length; i++) {
			num[data[i].getCol()]++;
		}
		for(int col =1;col<getCols();col++) {
			cpot[col]=cpot[col-1]+num[col-1];
		}
		for (int j = 0; j < data.length; j++) {
			int col=data[j].getCol();
			int pos=cpot[col];
			transformed[pos] = new Triple(data[j].getCol(), data[j].getRow(), data[j].getValue()); 
			cpot[col]++;
			count++;
		}
		System.out.println("时间复杂度：" + count);
		return new SparseMatrix(transformed, cols, rows);
	}

	@Override
	public String toString() {
		int count = 0;
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				sBuilder.append(matrix[i][j] + " , ");
				count++;
			}
			sBuilder.append(";\r\n");
		}
		sBuilder.append("count = " + count);
		return sBuilder.toString();
	}

}
