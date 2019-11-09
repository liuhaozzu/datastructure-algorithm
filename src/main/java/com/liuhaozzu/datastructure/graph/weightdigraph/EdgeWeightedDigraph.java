package com.liuhaozzu.datastructure.graph.weightdigraph;

import com.liuhaozzu.datastructure.graph.Bag;
import com.liuhaozzu.datastructure.graph.weightedgraph.Edge;

import java.io.BufferedReader;
import java.io.IOException;

public class EdgeWeightedDigraph {
    private int V;
    private int E;
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        init(V);
    }

    private void init(int V) {
        this.V=V;
        this.E=0;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public EdgeWeightedDigraph(BufferedReader reader) throws IOException {
        String line;
        int v = Integer.parseInt(reader.readLine().trim());
        init(v);
        int E = Integer.parseInt(reader.readLine().trim());
        this.E=E;
        while ((line = reader.readLine()) != null) {
            String[] a = line.split(" ");

            DirectedEdge de = new DirectedEdge(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Double.parseDouble(a[2]));
            addEdge(de);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge edge) {
        adj[edge.from()].add(edge);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                bag.add(e);
            }
        }
        return bag;
    }
    @Override
    public String toString() {
        System.out.println("v: " + V);
        System.out.println("e: " + E);

        for (int i = 0; i < V; i++) {
            System.out.print(i+" : ");
            for (DirectedEdge edge : adj(i)) {
                System.out.print(edge+" ");
            }
            System.out.println();
        }
        return null;
    }
}
