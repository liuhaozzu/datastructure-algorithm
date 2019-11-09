package com.liuhaozzu.datastructure.graph.weightdigraph;

public class DijkstraAllPairsSP {
    private DijkstraSPImpl[] all;

    DijkstraAllPairsSP(EdgeWeightedDigraph G) {
        all = new DijkstraSPImpl[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v] = new DijkstraSPImpl(G, v);
        }
    }

    Iterable<DirectedEdge> path(int s, int t) {
        return all[s].pathTo(t);
    }

    double distTo(int s, int t) {
        return all[s].distTo(t);
    }
}
