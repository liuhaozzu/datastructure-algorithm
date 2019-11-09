package com.liuhaozzu.datastructure.graph.weightedgraph;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.UF;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;

public class KruskalMST implements MST {

    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new ArrayDeque<>();

        MinPQ<Edge> pq = new MinPQ(Iterables.toArray(G.edges(), Edge.class));
        UF uf = new UF(G.V());

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();//从pq得到权重最小的边和他的顶点
            int v=e.either();
            int w = e.other(v);
            if (uf.connected(v, w)) {
                continue;//忽略失效的边
            }
            uf.union(v, w);//合并分量
            mst.add(e);//将边添加到最小生成树中
        }
    }


    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        return 0;
    }
}
