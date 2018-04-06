package com.liuhaozzu.datastructure.stack;

import java.util.List;
import java.util.Stack;

import com.google.common.collect.Lists;

public class EvaluateExpression {
	private static List<Character> operators = Lists.newArrayList(')', '+', '-', '*', '/', '(');

	public int evaluate(String expression) {
		Stack<Character> optr = new Stack<>();
		optr.push('#');
		Stack<Character> opnd = new Stack<>();

		char[] chars = expression.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (!operators.contains(c)) {
				// it's not a operator
				opnd.push(c);
			} else {
				switch (precede(optr.peek(), c)) {
				case '<':
					// top element's priority is lower
					optr.push(c);
					break;
				case '=':
					// remove top element
					optr.pop();
					break;
				case '>':
					// pop out the number in optr stack and push the result into opnd
					char theta = c;
					char b = opnd.pop();
					char a = opnd.pop();
					int result = operate(a, theta, b);
					opnd.push((char) result);
					break;

				default:
					break;
				}
			}

		}

		return 0;

	}

	private int operate(char a, char theta, char b) {
		int result = 0;
		switch (theta) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '*':
			result = a * b;
			break;
		case '/':
			result = a / b;
			break;
		default:
			break;
		}
		return result;
	}

	private char precede(Character peek, char c) {
		if (peek == '#') {
			return '<';
		}
		int indexOfPeek = operators.indexOf(peek);
		int indexOfC = operators.indexOf(c);
		if (indexOfPeek < indexOfC) {
			return '<';
		} else if (indexOfPeek > indexOfC || indexOfPeek == indexOfC) {
			return '>';
		} else if ((peek == '(' && c == ')') || (peek == '#' && c == '#')) {
			return '=';
		}
		throw new UnsupportedOperationException();
	}
}
