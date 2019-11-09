package com.liuhaozzu.datastructure.graph.weightdigraph;

import edu.princeton.cs.algs4.IndexMinPQ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class DijkstraSPImpl implements SP {
    private DirectedEdge edgeTo[];
    private double distTo[];
    private IndexMinPQ<Double> pq;

    public DijkstraSPImpl(EdgeWeightedDigraph g, int s) {
        edgeTo = new DirectedEdge[g.V()];
        distTo = new double[g.V()];
        pq = new IndexMinPQ<>(g.V());
        for (int i = 0; i < g.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s]=0D;
        pq.insert(s, 0D);
        while (!pq.isEmpty()) {
            relax(g, pq.delMin());
        }
    }

    @Override
    public double distTo(int v) {
        return distTo[v];
    }

    @Override
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    @Override
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

    @Override
    public boolean hasNegativeCycle() {
        return false;
    }


    private void relax(DirectedEdge edge) {
        int v = edge.from();
        int w = edge.to();
        if (distTo[w] > distTo(v) + edge.getWeight()) {
            distTo[w] = distTo(v) + edge.getWeight();
            edgeTo[w] = edge;
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge edge : G.adj(v)) {
            int w = edge.to();
            if (distTo[w] > distTo[v] + edge.getWeight()) {
                distTo[w] = distTo[v] + edge.getWeight();
                edgeTo[w] = edge;
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\git-repos\\datastructure-algorithm\\src\\main\\resources\\graph\\tinyEWG.txt")));
        EdgeWeightedDigraph ewg = new EdgeWeightedDigraph(reader);
        System.out.println(ewg.toString());
        int s = 0;
        SP sp = new DijkstraSPImpl(ewg, s);
        for (int t = 0; t < ewg.V(); t++) {
            System.out.print(s + " to " + t);
            System.out.printf("(%4.2f): ", sp.distTo(t));
            if (sp.hasPathTo(t)) {
                for (DirectedEdge e : sp.pathTo(t)) {
                    System.out.print(e + "    ");
                }
            }
            System.out.println();
        }
    }
}
