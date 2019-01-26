package com.liuhaozzu.datastructure.graph.digraph;

public interface Digraph {
    int V();
    int E();

    void addEdge(int v, int w);

    Iterable<Integer> adj(int v);

    Digraph reverse();
}
