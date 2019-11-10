package com.liuhaozzu.algorithm.sort;

import java.util.Arrays;

/**
 * @Author liuhao
 * @create 2019/11/10 0010 18:33
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {1, 5, 2, 9, 7, 3, 6};
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    int heapSize;
    public void sort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapSize--;
            maxHeapify(arr, 0);
        }
    }

    private void maxHeapify(int[] arr, int i) {
        int leftNodeIndex=2*i+1;
        int rightNodeIndex=2*i+2;
        int largestIndex = i;
        if (leftNodeIndex < heapSize && arr[i] < arr[leftNodeIndex]) {
            largestIndex = leftNodeIndex;
        }
        if (rightNodeIndex < heapSize && arr[largestIndex] < arr[rightNodeIndex]) {
            largestIndex = rightNodeIndex;
        }
        if (largestIndex != i) {
            swap(arr, i, largestIndex);
            //remaxify，使A[i]的值逐级下降
            maxHeapify(arr, largestIndex);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void buildMaxHeap(int[] arr) {
        int mid = arr.length / 2;
        heapSize = arr.length;
        for (int i = mid; i >=0; i--) {
            maxHeapify(arr, i);
        }
    }
}
