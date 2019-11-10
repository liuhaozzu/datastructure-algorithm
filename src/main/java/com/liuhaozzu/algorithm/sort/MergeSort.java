package com.liuhaozzu.algorithm.sort;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @Author liuhao
 * @create 2019/11/9 0009 21:47
 */
public class MergeSort {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,
                1,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1),
                new ThreadFactoryBuilder().build(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        executor.allowsCoreThreadTimeOut();
        executor.allowCoreThreadTimeOut(true);

        MergeSort mergeSort = new MergeSort();
        int[] arr = {1, 5, 2, 9, 8, 7, 3, 6};
        mergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int k = 0;
        int j = mid+1;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <=right) {
            temp[k++] = arr[j++];
        }
        k = 0;
        for (; left <= right; ) {
            arr[left++] = temp[k++];
        }
    }
}
