package com.liuhaozzu.datastructure.graph.digraph;

public class TransitiveClosure {
    private DirectedDFS[] all;

    TransitiveClosure(Digraph digraph) {
        all = new DirectedDFS[digraph.V()];
        for (int v = 0; v < digraph.V(); v++) {
            all[v] = new DirectedDFS(digraph, v);
        }
    }

    boolean reachable(int v, int w) {
        return all[v].marked(w);
    }
}
