package com.liuhaozzu.datastructure.graph.weightdigraph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BellmanFordSP implements SP{
    /**
     * 从起点到某个顶点的路径的长度
     */
    private double[] distTo;
    /**
     * 从起点到某个顶点的最后一条边
     */
    private DirectedEdge[] edgeTo;
    /**
     * 该顶点是否存在于队列中
     */
    private boolean[] onQ;
    /**
     * 正在被放松的顶点
     */
    private Queue<Integer> queue;
    /**
     * relax()调用的次数
     */
    private int cost;
    /**
     * edgeTo[] 中的是否有负权重环
     */
    private Iterable<DirectedEdge> cycle;

    public BellmanFordSP(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new ArrayDeque<>();
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s]=0D;
        queue.add(s);
        while (!queue.isEmpty() && !this.hasNegativeCycle()) {
            int v = queue.poll();
            onQ[v] = false;
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge edge : g.adj(v)) {
            int w = edge.to();
            if (distTo[w] > distTo[v] + edge.getWeight()) {
                distTo[w] = distTo[v] + edge.getWeight();
                edgeTo[w] = edge;
                if (!onQ[w]) {
                    queue.add(w);
                    onQ[w] = true;
                }
            }
            if (cost++ % g.V() == 0) {
                findNegativeCycle();
            }
        }
    }

    private void findNegativeCycle() {
        
    }

    @Override
    public double distTo(int v) {
        return 0;
    }

    @Override
    public boolean hasPathTo(int v) {
        return false;
    }

    @Override
    public Iterable<DirectedEdge> pathTo(int v) {
        return null;
    }

    @Override
    public boolean hasNegativeCycle() {
        return false;
    }
}
