package com.liuhaozzu.datastructure.string;

import java.util.Arrays;

public class StringDemo {
	public static void main(String[] args) {
		StringDemo demo = new StringDemo();
		int[] next = demo.getNext("abaabcac");
		System.out.println(Arrays.toString(next));
	}

	public int index(String src, String target, int pos) {

		// TODO: validate input params
		// TODO: quick fail: when src.lenght<pos+target.length ,return -1
		int count = 0;
		char[] srcs = src.toCharArray();
		char[] targets = target.toCharArray();
		int i = pos;
		int j = 0;
		while (i < src.length() && j < target.length()) {
			count++;
			if (srcs[i] == targets[j]) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}
		System.out.println("loop count: " + count);
		if (j == target.length()) {
			return i - j;
		} else {
			return -1;
		}
	}
	public int indexByKMP(String src, String target, int pos) {
		
		// TODO: validate input params
		// TODO: quick fail: when src.lenght<pos+target.length ,return -1
		int count = 0;
		char[] srcs = src.toCharArray();
		char[] targets = target.toCharArray();
		int i = pos;
		int j = 0;
		int[] next=getNext(target);
		while (i < src.length() && j < target.length()) {
			count++;
			if (              j<0 || srcs[i] == targets[j]) {
				i++;
				j++;
			} else {
				j=next[j];// pattern move to right
			}
		}
		System.out.println("loop count: " + count);
		if (j == target.length()) {
			return i - j;
		} else {
			return -1;
		}
	}

	private int[] getNext(String target) {
		int i=1;
		int j=0;
		int[] next=new int[target.length()];
		next[1]=0;
		char[] chars = target.toCharArray();
		while(i<target.length()) {
			if(j==0 || chars[i]==chars[j]) {
				++i;
				++j;
				next[i]=j;
			}else {
				j=next[j];
			}
		}
		return next;
	}
}
