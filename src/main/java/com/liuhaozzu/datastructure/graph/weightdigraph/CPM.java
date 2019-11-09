package com.liuhaozzu.datastructure.graph.weightdigraph;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class CPM {
    public static void main(String[] args) {
        int N = 0;
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(2 * N + 2);

        int s = 2*N;
        int t=2*N+1;
        for (int i = 0; i < N; i++) {
            String[] a= StdIn.readLine().split("\\s+");
            double duration = Double.parseDouble(a[0]);
            G.addEdge(new DirectedEdge(i, i + N, duration));
            G.addEdge(new DirectedEdge(s, i, 0D));

            G.addEdge(new DirectedEdge(i + N, t, 0D));
            for (int j = 1; j < a.length; j++) {
                int successor = Integer.parseInt(a[j]);
                G.addEdge(new DirectedEdge(i + N, successor, 0D));
            }
        }
        ACyclicLP lp = new ACyclicLP(G, s);

        StdOut.println("Start times");
        for (int i = 0; i < N; i++) {
            StdOut.printf("%4d: %5.1f \n", i, lp.distTo(i));
        }
        StdOut.printf("finish time: %5.1f \n", lp.distTo(t));


    }
}
