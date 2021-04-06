package com.liuhaozzu.algorithm.sort;

import java.util.Arrays;

/**
 * @author: liuhao01
 * @date: 2019-10-22 11:03
 */
public class QuickSort {


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {1, 3, 2};
        int[] arr2 = {1, 3, 2, 5, 9, 8, 7,6,11};


        quickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr2);
        System.out.println("arr2:" + Arrays.toString(arr2));

    }


    public void sort(int[] arr,int left,int right) {
        if (left < right) {
            int i = partition(arr, left, right);
            sort(arr, left, i-1);
            sort(arr, i + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int i=left;
        int j = right;
        int pivot = arr[right];
        while (i < j) {
            while (i<j &&arr[i] <= pivot) {
                i++;
            }
            while (i<j &&arr[j] >= pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, i, right);
        return i;
    }

    private void swap(int[] arr, int start, int endInclude) {
        int tmp = arr[start];
        arr[start] = arr[endInclude];
        arr[endInclude] = tmp;
    }
}
