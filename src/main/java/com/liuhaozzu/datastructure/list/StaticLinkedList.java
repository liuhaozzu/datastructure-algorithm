package com.liuhaozzu.datastructure.list;

public class StaticLinkedList<T, E> {
	private Node<E>[] container;
	private static final int DEFAULT_SIZE = 1024;
	private int currentSize =0;
	public StaticLinkedList() {
		container = new Node[DEFAULT_SIZE];
		initContainer();
	}

	public StaticLinkedList(int size) {
		if (size > 0) {
			container = new Node[size];
		} else if (size == 0) {
			container = new Node[0];
		} else {
			throw new IllegalArgumentException("size must > 0");
		}
		initContainer();
	}

	private int mallocNode() {
		int i=container[0].getNextIndex();
		// if the backup linked list is not null, return the index of the node; or return 0
		if(i!=0) {
			container[0].setNextIndex(container[i].getNextIndex());
		}
		return i;
	}
	private void freeNode(int k) {
		// collect the node with index = k to backup linked list
		container[k].setNextIndex(container[0].getNextIndex());
		container[0].setNextIndex(k);
	}
	
	private void difference(int s) {
		// create list of collection A
		// for(int i=0;i<)
	}
	
	private void initContainer() {
		for(int i=0;i<container.length;i++) {
			container[i].setNextIndex(i+1);
		}
		container[container.length-1].setNextIndex(0);
	}
	
	private class Node<E>{
		private T data;
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public int getNextIndex() {
			return nextIndex;
		}
		public void setNextIndex(int nextIndex) {
			this.nextIndex = nextIndex;
		}
		private int nextIndex;
	}
}
