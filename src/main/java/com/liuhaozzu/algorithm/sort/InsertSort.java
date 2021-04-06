package com.liuhaozzu.algorithm.sort;

import java.util.Arrays;

/**
 * @author: liuhao01
 * @date: 2019-10-22 15:10
 */
public class InsertSort {


    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] arr = {1, 3, 2};
        int[] arr2 = {1, 3, 2, 5, 9, 8, 7,6,11};


        insertSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr2);
        System.out.println("arr2:" + Arrays.toString(arr2));

    }

    public void sort(int[] arr, int left, int right) {
        int i=left;
        int j=i+1;
        for (; j < right; j++) {
            while (arr[j] < arr[i]) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
    }

}
