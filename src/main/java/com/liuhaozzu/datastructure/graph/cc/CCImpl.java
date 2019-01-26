package com.liuhaozzu.datastructure.graph.cc;

import com.liuhaozzu.datastructure.graph.Graph;

public class CCImpl implements CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CCImpl(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    @Override
    public boolean connected(int v, int w) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int id(int v) {
        return 0;
    }
}
