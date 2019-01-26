package com.liuhaozzu.datastructure.graph.symbolgraph;

import com.liuhaozzu.datastructure.graph.Graph;

public interface SymbolGraph {
    boolean contains(String key);

    int index(String key);

    String name(int v);

    Graph G();
}
