package com.liuhaozzu.datastructure.graph.digraph;

public class KosarajuSCC2 {
    private boolean[] marked ;
    private int[] id;//顶点所在的的连通分量的序号
    private int count;

    public KosarajuSCC2(Digraph dg) {
        marked = new boolean[dg.V()];
        id = new int[dg.V()];
        DepthFirstOrder order = new DepthFirstOrder(dg.reverse());
        for (int w : order.reversePost()) {
            if (!marked[w]) {
                dfs(dg, w);
                count++;
            }
        }
    }

    private void dfs(Digraph dg, int w) {
        marked[w] = true;
        id[w] = count;
        for (int v : dg.adj(w)) {
            if (!marked[v]) {
                dfs(dg, v);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
