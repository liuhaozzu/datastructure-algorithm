package com.liuhaozzu.algorithm.devideandconquer;

import com.google.gson.Gson;

/**
 * @Author liuhao
 * @create 2019/11/9 0009 23:47
 */
public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] arr = {1, -1, 2, -9, 7, -3, 6};
        Dto dto = maxSubArray.findMaxSubArray(arr);
        System.out.println(new Gson().toJson(dto));
    }


    public Dto findMaxSubArray(int[] arr) {
        return findMaxSubArray(arr, 0, arr.length - 1);
    }

    private Dto findMaxSubArray(int[] arr, int left, int right) {
        if (left == right) {
            return new Dto().setLeft(left).setRight(right).setSum(arr[left]);
        }
        int mid = (left + right) / 2;
        Dto leftMaxSum = findMaxSubArray(arr, left, mid);
        Dto rightMaxSum = findMaxSubArray(arr, mid + 1, right);
        Dto crossMaxSum = findCrossMaxSubArray(arr, left, mid, right);
        if (leftMaxSum.compareTo(rightMaxSum) >= 0 && leftMaxSum.compareTo(crossMaxSum) >= 0) {
            return leftMaxSum;
        } else if (rightMaxSum.compareTo(leftMaxSum) >= 0 && rightMaxSum.compareTo(crossMaxSum) >= 0) {
            return rightMaxSum;
        } else {
            return crossMaxSum;
        }
    }

    private Dto findCrossMaxSubArray(int[] arr, int left, int mid, int right) {
        int leftSumMax = Integer.MIN_VALUE;
        int sum=0;
        int maxLeft = mid;
        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            if (sum > leftSumMax) {
                leftSumMax = sum;
                maxLeft = i;
            }
        }
        int rightSumMax = Integer.MIN_VALUE;
        sum=0;
        int maxRight = mid;
        for (int j = mid + 1; j <= right; j++) {
            sum += arr[j];
            if (sum > rightSumMax) {
                rightSumMax = sum;
                maxRight=j;
            }
        }
        return new Dto().setLeft(maxLeft).setRight(maxRight).setSum(leftSumMax + rightSumMax);
    }


    private static class Dto implements Comparable<Dto> {
        int left;
        int right;
        int sum;

        public int getLeft() {
            return left;
        }

        public Dto setLeft(int left) {
            this.left = left;
            return this;
        }

        public int getRight() {
            return right;
        }

        public Dto setRight(int right) {
            this.right = right;
            return this;
        }

        public int getSum() {
            return sum;
        }

        public Dto setSum(int sum) {
            this.sum = sum;
            return this;
        }

        @Override
        public int compareTo(Dto o) {
            return Integer.compare(this.sum, o.sum);
        }
    }
}
