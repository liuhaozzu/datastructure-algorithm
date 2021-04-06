package com.liuhaozzu.datastructure.string;

import java.util.*;

/**
 * given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3
 * Given "bbb", the answer is "b", with the length of 1
 * Given "pwwkew", the answer is "wke", with the length of 3
 *
 * @author: liuhao01
 * @date: 2019-10-17 19:33
 */
public class LongestRepeatingSubString {


    public static void main(String[] args) {
        LongestRepeatingSubString longestRepeatingCharacters = new LongestRepeatingSubString();
        System.out.println(longestRepeatingCharacters.getLongestSubString("abcahidefg"));
        System.out.println(longestRepeatingCharacters.getLongestSubString("bbb"));
        System.out.println(longestRepeatingCharacters.getLongestSubString("pwwkew"));
    }

    private Result getLongestSubString(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        int len = str.length();
        int i = 0;
        int j=0;
        int longestLen=0;
        String longesgStr = null;
        Set<Character> set = new LinkedHashSet<>();
        for (; i < len && j<len; ) {
            Character cur = str.charAt(j);
            if (!set.contains(cur)) {
                j++;
                set.add(cur);
                longestLen = Math.max(longestLen, j - i);
                longesgStr=set.toString();

            } else {
                set.remove(str.charAt(i++));
            }
        }
        return new Result(longesgStr, longestLen);

    }

    private Result getLongestSubStringOptimized(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        int len = str.length();
        int i = 0;
        int j=0;
        int longestLen=0;
        String longesgStr = null;
        //Set<Character> set = new LinkedHashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (; i < len && j<len;j++ ) {
            Character cur = str.charAt(j);
            if (!map.containsKey(cur)) {
                //set.add(cur);
                longestLen = Math.max(longestLen, j - i);
                //longesgStr=set.toString();
                map.put(cur, j);
            } else {
                i = map.get(cur)+1;
            }
        }
        longesgStr = str.substring(i, j);
        return new Result(longesgStr, j-i);

    }

    private static class Result{
        String longestChars;
        int length;

        Result(String longestChars, int length) {
            this.longestChars = longestChars;
            this.length = length;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "longestChars='" + longestChars + '\'' +
                    ", length=" + length +
                    '}';
        }
    }
}
