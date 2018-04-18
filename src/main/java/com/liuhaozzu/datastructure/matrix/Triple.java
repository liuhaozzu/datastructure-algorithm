package com.liuhaozzu.datastructure.matrix;

public class Triple {

	private int row;
	private int col;
	private int value;

	public Triple(int row, int col, int value) {
		super();
		this.row = row;
		this.col = col;
		this.value = value;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
