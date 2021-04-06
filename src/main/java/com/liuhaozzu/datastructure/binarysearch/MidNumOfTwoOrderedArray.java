package com.liuhaozzu.datastructure.binarysearch;

import com.liuhaozzu.datastructure.graph.In;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author: liuhao01
 * @date: 2019-10-18 10:32
 */
public class MidNumOfTwoOrderedArray {
    private int[] small;
    private int[] large;

    public static void main(String[] args) {
        int[] small = {1, 3, 5, 7, 9};
        int[] large = {2, 4, 6, 8, 10, 12,100};
        MidNumOfTwoOrderedArray m = new MidNumOfTwoOrderedArray(small, large);
        System.out.println(m.getMid());
    }

    public MidNumOfTwoOrderedArray(int[] arr0, int[] arr1) {
        //特殊数据处理
        if (arr0 == null || arr1 == null) {
            //do something
            throw new IllegalArgumentException("arr0 and arr1 must not be null");
        }
        if (arr0.length > arr1.length) {
            small = arr1;
            large = arr0;
        } else {
            small=arr0;
            large = arr1;
        }
    }

    public double getMid() {
        int smallLen = small.length;
        int largeLen = large.length;

        int c1Max=0,c1Min=0,c2Max=0,c2Min=0;
        int lo = 0, hi = smallLen * 2;
        int k = smallLen + largeLen;

        while (lo <= hi) {
            int c1 = (lo + hi) / 2;
            int c2 = k - c1;
            c1Min = c1 == 0 ? Integer.MIN_VALUE : small[(c1-1) / 2];
            c1Max = c1 == smallLen*2 ? Integer.MAX_VALUE : small[c1 / 2];
            c2Min = c2 == 0 ? Integer.MIN_VALUE : large[(c2-1) / 2];
            c2Max = c2 == largeLen * 2 ? Integer.MAX_VALUE : large[c2  / 2];

            if (c1Min > c2Max) {
                hi = c1 - 1;
            } else if (c2Min > c1Max) {
                lo = c1 + 1;
            } else {
                break;
            }
        }
        return (Math.max(Integer.valueOf(c1Min).doubleValue(), Integer.valueOf(c2Min).doubleValue()) + (double) Math.min(c1Max, c2Max))/2.0;
    }
}
