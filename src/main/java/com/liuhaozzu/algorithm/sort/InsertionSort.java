package com.liuhaozzu.algorithm.sort;

import java.util.Arrays;

/**
 * @Author liuhao
 * @create 2019/11/9 0009 21:40
 */
public class InsertionSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int k=1;
        int len = arr.length;
        for (; k < len; k++) {
            int i=k-1;
            int temp = arr[k];
            while (arr[i] > temp && i > 0) {
                arr[i + 1] = arr[i];
                arr[i] = temp;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr = {1, 5, 2, 9, 7, 3, 6};
        insertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
