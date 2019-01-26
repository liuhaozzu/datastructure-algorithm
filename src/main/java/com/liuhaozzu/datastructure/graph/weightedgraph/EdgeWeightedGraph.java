package com.liuhaozzu.datastructure.graph.weightedgraph;

import com.liuhaozzu.datastructure.graph.Bag;
import edu.princeton.cs.algs4.In;

import java.io.*;

public class EdgeWeightedGraph {
    private int v;
    private int e;
    private Bag<Edge>[] adj;
    public EdgeWeightedGraph(int v) {
        init(v);
    }

    private void init(int v) {
        this.v =v;
        this.e=0;
        adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
    }

    public EdgeWeightedGraph(BufferedReader reader) throws IOException {
        String line;
        int v = Integer.parseInt(reader.readLine().trim());
        init(v);
        int e = Integer.parseInt(reader.readLine().trim());
        this.e=e;
        while ((line = reader.readLine()) != null) {
            String[] a = line.split(" ");

            Edge edge = new Edge(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Double.parseDouble(a[2]));
            addEdge(edge);

        }
    }


    int V(){
        return v;
    }

    int E(){
        return e;
    }

    void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        e++;
    }

    Iterable<Edge> adj(int v) {
        return adj[v];
    }

    Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<>();
        for (int v = 0; v < V(); v++) {
            for (Edge edge : adj(v)) {
                if (edge.other(v) > v) {
                    b.add(edge);
                }
            }
        }
        return b;
    }

    @Override
    public String toString() {
        System.out.println("v: " + v);
        System.out.println("e: " + e);

        for (int i = 0; i < v; i++) {
            System.out.print(i+" : ");
            for (Edge edge : adj(i)) {
                System.out.print(edge+" ");
            }
            System.out.println();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\git-repos\\datastructure-algorithm\\src\\main\\resources\\graph\\tinyEWG.txt")));
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(reader);
        System.out.println(ewg.toString());
    }
}
