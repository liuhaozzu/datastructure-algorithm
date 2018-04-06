package com.liuhaozzu.datastructure.stack;

import java.util.Stack;

/**
 *    0 1 2 3 4 5 6 7 8 9
 * -----------------------
 * 0| 1 1 1 1 1 1 1 1 1 1
 * 1| 1 S 0 1 0 0 0 1 0 1
 * 2| 1 0 0 1 0 0 0 1 0 1
 * 3| 1 0 0 0 0 1 1 0 0 1
 * 4| 1 0 1 1 1 0 0 1 0 1
 * 5| 1 0 0 0 1 0 0 1 0 1
 * 6| 1 0 1 0 0 0 1 0 0 1
 * 7| 1 0 1 1 1 0 1 1 0 1
 * 8| 1 1 0 0 0 0 0 0 E 1
 * 9| 1 1 1 1 1 1 1 1 1 1
 * TODO What the class does
 * @author liuhaozzu
 * @date   Apr 5, 2018-2:12:02 PM
 *
 */
public class Maze {

	private class Node {
		// the order in the path
		private int ord;
		int[][] maze;
		int direction;
		
	}
	public Stack<int[][]> mazePath(int[][] maze,int[][] startPoint, int[][] endPoint) {
		Stack<int[][]> stack = new Stack<>();
		int[][] curPos = startPoint;
		int curStep =1;
		do {
			if(canPass(curPos)) {
				footPrint(curPos);
				stack.push(curPos);
				if(curPos==endPoint) {
					return stack;
				}
				//curPos=curPos.
			}
		}while(!stack.isEmpty());
		return null;
		
	}
	private void footPrint(int[][] curPos) {
		// TODO Auto-generated method stub
		
	}
	private boolean canPass(int[][] curPos) {
		// TODO Auto-generated method stub
		return false;
	}
}
