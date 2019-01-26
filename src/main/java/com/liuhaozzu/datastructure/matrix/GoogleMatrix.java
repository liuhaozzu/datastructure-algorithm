package com.liuhaozzu.datastructure.matrix;

public class GoogleMatrix {
    private int N;
    double[][] a = new double[N][N];

    public GoogleMatrix(int n) {
        this.N = n;
    }

    double[] x = new double[N];
    double[] b = new double[N];

    //初始化a[][]和x[]

    public double[] cal() {
        for (int i = 0; i < N; i++) {
            double sum = 0D;
            for (int j = 0; j < a[i].length; j++) {
                sum += a[i][j] * x[j];
            }
            b[i] = sum;
        }
        return b;
    }

}
