package com.liuhaozzu.datastructure.string;

import edu.princeton.cs.algs4.Alphabet;

public class Count {
    public static void main(String[] args) {
        Alphabet alpha = new Alphabet("0123456789");
        int R = alpha.radix();
        int[] count = new int[R];
        String s = Double.toString(Math.PI);
        int N = s.length();
        for (int i = 0; i < N; i++) {
            if (alpha.contains(s.charAt(i))) {
                count[alpha.toIndex(s.charAt(i))]++;
            }
        }
        for (int c = 0; c < R; c++) {
            System.out.println(alpha.toChar(c)+"  "+count[c]);
        }
    }
}
