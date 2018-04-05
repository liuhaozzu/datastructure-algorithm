package com.liuhaozzu.datastructure.list;

public class SequentialLinearList<T> {
	private Object[] container;
	private static final int DEFAULT_SIZE = 1024;
	private int currentSize =0;
	public SequentialLinearList() {
		container = new Object[DEFAULT_SIZE];
	}

	public SequentialLinearList(int size) {
		if (size > 0) {
			container = new Object[size];
		} else if (size == 0) {
			container = new Object[0];
		} else {
			throw new IllegalArgumentException("size must > 0");
		}
	}

	public boolean insert(int i, T e) {
		// insert a new element before the ith (start from 0) element
		// i should be 0<=i<= container.length-1
		if(i<0 && i>=container.length) {
			throw new IllegalArgumentException("i should be 0<=i<= " + (container.length-1));
		}
		int pointer=currentSize;
		while(pointer>i) {
			container[pointer]=container[pointer-1];
			pointer--;
		}
		container[pointer]=e;
		++currentSize;
		return true;
	}
	public boolean delete(int i, T e) {
		// insert a new element before the ith (start from 0) element
		// i should be 0<=i<= container.length-1
		if(i<0 && i>=currentSize) {
			throw new IllegalArgumentException("i should be 0<=i<= " + (container.length-1));
		}
		int pointer=i;
		while(pointer<currentSize) {
			container[pointer]=container[pointer+1];
			pointer++;
		}
		container[pointer]=e;
		--currentSize;
		return true;
	}
}
