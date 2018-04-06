package com.liuhaozzu.datastructure.stack;

import java.util.Stack;

public class NumberConverter {

	public String dec2Oct(int source) {
		Stack<Integer> stack = new Stack<>();
		while(source>0) {
			int mod = source%8;
			stack.push(mod);
			source= source/8;
		}
		StringBuilder sBuilder= new StringBuilder();
		while(!stack.isEmpty()) {
			sBuilder.append(stack.pop());
		}
		return sBuilder.toString();
	}
}
