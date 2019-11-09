package com.liuhaozzu.datastructure.graph.digraph;

import com.liuhaozzu.datastructure.graph.symbolgraph.SymbolGraph;
import com.liuhaozzu.datastructure.graph.symbolgraph.impl.SymbolGraphImpl;
import com.liuhaozzu.datastructure.graph.weightdigraph.EdgeWeightedDigraph;

import java.io.IOException;

public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph G) {
        DirectedCycle cycleFinder = new DirectedCycle(G);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Topological(EdgeWeightedDigraph g) {

    }

    boolean isDAG() {
        return order != null;
    }

    public Iterable<Integer> order() {
        return order;
    }

    public static void main(String[] args) throws IOException {
        String filename = "";
        String separator = "\\/";
        SymbolGraph digraph = new SymbolGraphImpl(filename, separator);

        /*Topological top = new Topological(digraph);
        for (int v : top.order) {
            System.out.println(digraph.);
        }*/
    }
}
