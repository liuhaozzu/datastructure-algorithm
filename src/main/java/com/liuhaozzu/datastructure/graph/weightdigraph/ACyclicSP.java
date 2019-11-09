package com.liuhaozzu.datastructure.graph.weightdigraph;

import com.liuhaozzu.datastructure.graph.digraph.Topological;

public class ACyclicSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public ACyclicSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0D;
        Topological top = new Topological(G);
        for (int v : top.order()) {
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph g, int v) {

    }
}
