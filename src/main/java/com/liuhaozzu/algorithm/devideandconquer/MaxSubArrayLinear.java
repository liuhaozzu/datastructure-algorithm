package com.liuhaozzu.algorithm.devideandconquer;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author liuhao
 * @create 2019/11/9 0009 23:47
 */
public class MaxSubArrayLinear {

    public static void main(String[] args) {
        MaxSubArrayLinear maxSubArray = new MaxSubArrayLinear();
        int[] arr = {1, -1, 2, -9, 7, -3, 6};
        //int[] arr = {4, -5, 1, 5};
        Dto dto = maxSubArray.findMaxSubArray(arr);
        System.out.println(new Gson().toJson(dto));

    }


    public Dto findMaxSubArray(int[] arr) {
        return findMaxSubArray(arr, arr.length);
    }

    /**
     * 已知 A[1..1] 的最大子数组是第一个元素，要么 A[1..2] 的最大子数组要么是 A[1..1] 的最大子数组，要么是 A[i..2] 的最大子数组。
     * 换个说法就是 A[1..2] 的最大子数组要么包含第二个元素，要么不包含第二个元素；
     * 所以①需要从包含第二个元素和不包含第二个元素的两种情况里面选一个最大的值出来。
     * 1. 不包含第二个元素的值是可以确定的：就是A[i...j]的最大子数组，是已知的，称之为 前最大子数组。
     * 2. 包含第二个元素的最大子数组：边界最大子数组
     * 2.1 只包含第二个元素（A[j+1]）
     * 2.2 不只包含第二个元素(前一个元素的边界最大子数组+A[j+1])
     * <p>
     * 当计算A[1..2]的最大子数组时，需要的值分别有：前最大子数组（已知）、A[2]的值（已知）、前一个元素的边界最大子数组。
     * <p>
     * 扩展-记录索引值
     * 这里因为与代码结合着讨论的，所以下标从0开始。
     * 这里再说一下两个自定义名词：
     * 前最大子数组：不包含当前元素的最大子数组
     * 边界最大子数组：只包含当前元素和不只包含当前元素，两种情况的较大值
     * <p>
     * 我们以数组{1,-2,3,10,-4,7,2,-48}为例。
     * 初始时两个索引都为0，最大子数组和边界最大子数组都是1；
     * 当迭代索引为1时，本次值为-2，前一元素的边界最大子数组为1，所以边界最大子数组为-1，前最大子数组为1，本次迭代的最大子数组为前最大子数组，值为1，不更新索引；
     * 当迭代索引为2时，本次值为3，前边界最大子数组为-1，所以边界最大子数组为3；前最大子数组为1，本次迭代的最大子数组为边界最大子数组，值为3；此时需要把起始索引和终止索引都更新为当前索引，即2；
     * 当迭代索引为3是，本次值为10，前边界最大子数组为3，所以边界最大子数组为13，前最大子数组为*3，本次迭代的最大子数组为边界最大子数组*，值为13；此时需要把终止索引更新为当前索引，却不能更新起始索引；
     * …………
     * 索引为2和索引为3的共同点在于，都是边界最大子数组大于前最大子数组，都更新了终止索引；差别在于，索引2为时，边界最大子数组只包含了索引对应的值，所以可以更新起始索引；而索引3的边界最大子数组也包含了前一元素，所以只能更新终止索引。
     * <p>
     * 此时可以把需要更新索引的情况概括如下：
     * 条件①：本次的边界最大子数组只包含当前值，且大于前最大子数组，则更新起始索引；
     * 条件②：本次的边界最大子数组大于前最大子数组，则更新终止索引；
     * <p>
     * 更新终止索引的条件②应该是充分且必要的，然而更新起始索引的条件①是充分的，确并不是必要的。考虑一下数组{4,-5,1,5}，当索引为2时，边界最大子数组为1，前最大子数组为4，只满足条件1的前半部分，然而整个数组的最大子数组的起始索引却是2。所以条件①需要进行补充。
     * <p>
     * 以下是第二个版本的两个条件：
     * 条件①：本次的边界最大子数组只包含当前值
     * 条件②：本次的边界最大子数组大于前最大子数组
     * 当满足条件①时，把当前索引记录为缓存索引，但并不更新起始索引；当满足条件②时，更新终止索引为当前索引，更新起始索引为缓存索引。
     * 条件②的满足总是要在条件①之后的。条件①可能标志着一个新的开始，因为条件①可以重复满足，而条件②必定标志着一个结束。
     * ————————————————
     * 版权声明：本文为CSDN博主「zj0395」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/zj0395/article/details/76284342
     *
     * @param arr
     * @param length
     * @return
     */
    private Dto findMaxSubArray(int[] arr, int length) {
        //前一个元素的边界最大子数组
        int boundary = arr[0];
        //前最大子数组
        int maxArr = arr[0];
        int left=0;
        int right=0;
        int tempLeftIndex = 0;
        for (int i = 1; i < length; i++) {
            //确定边界最大子数组
            if (boundary + arr[i] >= arr[i]) {
                boundary += arr[i];
            } else {
                boundary = arr[i];
                tempLeftIndex=i;
            }
            //前最大子数组和边界最大子数组取最大值
            if (maxArr < boundary) {
                maxArr = boundary;
                right=i;
                left = tempLeftIndex;
            }
        }
        return new Dto().setLeft(left).setRight(right).setSum(maxArr);
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
