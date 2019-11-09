package com.liuhaozzu.datastructure.graph.weightedgraph;

import edu.princeton.cs.algs4.IndexMinPQ;


public class PrimMST implements MST {
    private Edge[] edgeTo;//距离树最近的边
    private double[] distTo;//distTo[w] = edgeTo[w].weight()
    private boolean[] marked;//如果v在树种则为true
    private IndexMinPQ<Double> pq;//有效的横切边

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<>(G.V());
        distTo[0]=0.0;
        pq.insert(0,0.0);//用顶点0和权重0初始化pq
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());//将最近的顶点添加到树中
        }
    }

    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            int w = e.other(v);
            if (marked[w]) {
                //v-w失效
                continue;
            }
            if (e.getWeight() < distTo[w]) {
                //连接w和树的最佳边Edge边为e
                edgeTo[w]=e;
                distTo[w]=e.getWeight();
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return null;
    }

    @Override
    public double weight() {
        return 0;
    }
}
