package com.liuhaozzu.datastructure.matrix;

public class SparseVectorUsage {
    private int N;

    public void usage() {
        SparseVector[] a;
        a = new SparseVector[N];
        double[] x = new double[N];
        double[] b = new double[N];
        for (int i = 0; i < N; i++) {
            b[i] = a[i].dot(x);
        }
    }
}
