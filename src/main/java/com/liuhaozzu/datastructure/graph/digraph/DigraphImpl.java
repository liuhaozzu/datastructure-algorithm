package com.liuhaozzu.datastructure.graph.digraph;

import com.liuhaozzu.datastructure.graph.Bag;

public class DigraphImpl implements Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public DigraphImpl(int V) {
        this.V = V;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }

    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public Digraph reverse() {
        Digraph r = new DigraphImpl(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                r.addEdge(w, v);
            }
        }
        return r;
    }
    @Override
    public String toString() {
        String s=V+" vertics, "+E+" edges\n";
        for (int v = 0; v < V; v++) {
            s+=v+": ";
            for (int w : this.adj[v]) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}
