package com.liuhaozzu.datastructure.graph.digraph;

public class DirectedDFS {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    public DirectedDFS(Digraph G, Iterable<Integer> source) {
        marked = new boolean[G.V()];
        for (int s : source) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    boolean marked(int v) {
        return marked[v];
    }
}
