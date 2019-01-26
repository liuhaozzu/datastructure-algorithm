package com.liuhaozzu.datastructure.graph.path;

import com.liuhaozzu.datastructure.graph.Graph;

import java.io.File;
import java.io.IOException;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstPaths implements Paths {
    private boolean[] marked;//到达该顶点的最短路径已知吗
    private int[] edgeTo;//到达该顶点的已知路径上的最后一个顶点
    private final int s;//起点

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        //标记起点
        marked[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();//从队列中删除下一个顶点
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    //对于未被标记过的顶点
                    edgeTo[w] = v;//保存最短路径的最后一条边
                    marked[w] = true;//标记它，因为最短路径已知
                    queue.add(w);//将它添加到队列中

                }
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
            path.add(x);
        }
        path.add(s);
        return path;
    }

    public static void main(String[] args) throws IOException {
        Graph graph = new Graph(new File("D:\\git-repos\\datastructure-algorithm\\src\\main\\resources\\graph\\tinyCG.txt"));
        System.out.println(graph);
        BreadthFirstPaths paths = new BreadthFirstPaths(graph, 0);
        System.out.println(paths.hasPathTo(4));
        System.out.println(paths.pathTo(4));
    }
}
