package com.liuhaozzu.datastructure.graph;

import java.io.*;
import java.util.Arrays;

public  class Graph {
    private final int V;//顶点数目
    private int E;//边的数目
    private Bag<Integer>[] adj;
    public Graph(int V){
        this.V=V;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v=in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public Graph(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        this.V = Integer.parseInt(reader.readLine().trim());
        //this.E = Integer.parseInt(reader.readLine().trim());
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
        Integer.parseInt(reader.readLine().trim());
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] vw=line.split(" ");
            //System.out.println(Arrays.toString(vw));
            int v = Integer.parseInt(vw[0]);
            int w = Integer.parseInt(vw[1]);
            addEdge(v, w);
        }
    }

    /**
     * 顶点数
     * @return
     */
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
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

    public static void main(String[] args) throws IOException {
        Graph graph = new Graph(new File("D:\\git-repos\\datastructure-algorithm\\src\\main\\resources\\graph\\tinyG.txt"));
        System.out.println(graph);
    }
}
