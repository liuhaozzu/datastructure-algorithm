package com.liuhaozzu.datastructure.matrix;

public class SparseVector {
    private HashST<Integer, Double> st;

    public SparseVector() {
        this.st = new HashST<>();
    }

    public int size() {
        return st.size();
    }

    public void put(int i, double x) {
        st.put(i, x);
    }

    public double get(int i) {
        if (!st.contains(i)) {
            return 0.0D;
        } else {
            return st.get(i);
        }
    }

    public double dot(double[] that) {
        double sum=0D;
        for (int i : st.keys()) {
            sum += that[i] * this.get(i);
        }
        return sum;
    }

}
