package com.liuhaozzu.datastructure.graph.path;

import com.liuhaozzu.datastructure.graph.Graph;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class DeepFirstPaths implements Paths {
    private boolean[] marked;//这个顶点调用过dfs()了吗？
    private int[] edgeTo;//从起点到一个顶点的已知路径上的最后一个顶点
    private final int s;//起点

    public DeepFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Graph G = new Graph(new File("D:\\git-repos\\datastructure-algorithm\\src\\main\\resources\\graph\\tinyCG.txt"));
        System.out.println(G);
        int s = 0;
        Paths search = new DeepFirstPaths(G, s);
        for (int v = 0; v < G.V(); v++) {
            System.out.print(s + " to " + v + ": ");
            if (search.hasPathTo(v)) {
                for (int x : search.pathTo(v)) {
                    if (x == s) {
                        System.out.print(x);
                    } else {
                        System.out.print("-" + x);
                    }
                }
            }
            System.out.println();
        }
        System.out.println(search.pathTo(5));
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
