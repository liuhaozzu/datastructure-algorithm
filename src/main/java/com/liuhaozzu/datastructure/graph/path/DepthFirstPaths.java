package com.liuhaozzu.datastructure.graph.path;

import com.liuhaozzu.datastructure.graph.Graph;
import com.liuhaozzu.datastructure.graph.In;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class DepthFirstPaths implements Paths{
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }


    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!marked[v]) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push( x);
        }
        path.push(s);
        return path;
    }
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph(new File("D:\\git-repos\\datastructure-algorithm\\src\\main\\resources\\graph\\tinyCG.txt"));
        System.out.println(graph);
        DepthFirstPaths paths = new DepthFirstPaths(graph, 0);
        System.out.println(paths.hasPathTo(4));
        System.out.println(paths.pathTo(4));
    }
}
