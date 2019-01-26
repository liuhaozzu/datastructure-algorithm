package com.liuhaozzu.datastructure.graph.weightedgraph;

import com.google.common.collect.MinMaxPriorityQueue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrimMST implements MST{
    private boolean[] marked;//最小生成树的顶点
    private Queue<Edge> mst;//最小生成树的边
    private PriorityQueue<Edge> pq;//横切边（包括失效的边）

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new PriorityQueue<>();
        marked = new boolean[G.V()];
        mst = new ArrayDeque<>();
        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();//从pq中取出权重最小的边
            int v = edge.either();
            int w = edge.other(v);
            if (marked[v] && marked[w]) {
                continue;//跳过失效边
            }
            mst.add(edge);//将边添加到最小生成树中
            //将顶点v或w添加到树种
            if (!marked[v]) {
                visit(G, v);
            }
            if (!marked[w]) {
                visit(G, w);
            }

        }
    }

    private void visit(EdgeWeightedGraph g, int v) {
        //标记顶点v，并将所有连接v和未被标记顶点的边加入pq
        marked[v] = true;
        for (Edge edge : g.adj(v)) {
            if (!marked[edge.other(v)]) {
                pq.add(edge);
            }
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

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\git-repos\\datastructure-algorithm\\src\\main\\resources\\graph\\tinyEWG.txt")));
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(reader);
        System.out.println(ewg.toString());
        LazyPrimMST lpMST = new LazyPrimMST(ewg);
        System.out.println(lpMST.edges());
    }
}
