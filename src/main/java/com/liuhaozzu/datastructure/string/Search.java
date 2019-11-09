package com.liuhaozzu.datastructure.string;


public class Search {
    public static int search(String pat, String txt) {
        int count = 0;
        int M =pat.length();
        int N = txt.length();
        for (int i = 0; i <= N-M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    count++;
                    break;
                } else {
                    count++;
                }
            }
            if (j == M) {
                System.out.println("count1::::::"+count);
                return i;//找到匹配
            }
        }
        System.out.println("count2::::::"+count);
        return N;//未找到匹配
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("aac");
        for (int i = 0; i < 100000; i++) {
            builder.append("aa");
        }
        builder.append("aac");
        String txt = builder.toString();
        System.out.println("txt.length=" + txt.length());
        long start = System.currentTimeMillis();
        search("aac", txt);
        System.out.println("cost:"+(System.currentTimeMillis()-start));
    }
}
