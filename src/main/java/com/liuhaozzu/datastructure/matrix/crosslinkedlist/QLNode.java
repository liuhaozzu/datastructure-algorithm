package com.liuhaozzu.datastructure.matrix.crosslinkedlist;

import com.liuhaozzu.datastructure.matrix.Triple;

public class QLNode {

	private Triple data;
	private QLNode right;
	private QLNode down;

    public QLNode(Triple data, QLNode right, QLNode down) {
        this.data = data;
        this.right = right;
        this.down = down;
    }

    public Triple getData() {
        return data;
    }

    public QLNode setData(Triple data) {
        this.data = data;
        return this;
    }

    public QLNode getRight() {
        return right;
    }

    public QLNode setRight(QLNode right) {
        this.right = right;
        return this;
    }

    public QLNode getDown() {
        return down;
    }

    public QLNode setDown(QLNode down) {
        this.down = down;
        return this;
    }
}
