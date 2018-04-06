package com.liuhaozzu.datastructure.stack.recursion;

public class Hanoi {

	public void hanoi(int n, char x, char y, char z) {//1
		if (n == 1) {//2
			move(x, 1, z);// 3 move panel 1 from x to z
		} else { //4
			hanoi(n - 1, x, z, y);// 5 move panel 1~n-1 from x to y
			move(x, n, z); //6
			hanoi(n - 1, y, x, z);//7
		}//8
	}//9

	private void move(char from, int i, char to) {
		System.out.println("move " + i + " from " + from + " ---> " + to);
	}
}
