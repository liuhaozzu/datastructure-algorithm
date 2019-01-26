package com.liuhaozzu.datastructure.graph;

import java.util.WeakHashMap;

public class DeepFirstSearch implements Search {

    private boolean[] marked;
    private int count;

    public DeepFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v]=true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }


    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }
}
