package com.liuhaozzu.datastructure.stack;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LineEdit {

	public static void main(String[] args) {
		InputStreamReader reader = new InputStreamReader(System.in);
		Stack<Character> stack = new Stack<>();
		char[] cbuf = new char[1];
		
		try {
			for(;;) {
				while (reader.read(cbuf) != -1) {
					if (cbuf[0] == '#') {
						if (!stack.isEmpty()) {
							stack.pop();
						}
					} else if (cbuf[0] == '@') {
						stack.clear();
					} else if (cbuf[0] == '\n') {
						break;
					} else {
						stack.push(cbuf[0]);
					}
				}
				StringBuilder sBuilder = new StringBuilder();
				while(!stack.isEmpty()) {
					sBuilder.append(stack.pop());
				}
				System.out.println("command is : " + sBuilder.reverse().toString());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
