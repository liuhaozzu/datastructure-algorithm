package com.liuhaozzu.datastructure.graph.symbolgraph;

import com.liuhaozzu.datastructure.graph.Graph;
import com.liuhaozzu.datastructure.graph.path.BreadthFirstPaths;
import com.liuhaozzu.datastructure.graph.symbolgraph.impl.SymbolGraphImpl;

import java.io.IOException;

public class DegreesOfSeparation {
    public static void main(String[] args) throws IOException {
        String stream = "D:\\git-repos\\datastructure-algorithm\\src\\main\\resources\\symbolgraph\\movies.txt";

        String sp = "\\/";
        SymbolGraph sg = new SymbolGraphImpl(stream, sp);
        Graph G = sg.G();
        String source = "Fanning, Dennis";

        if (!sg.contains(source)) {
            System.out.println(source + " not in database:");
            return;
        }
        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        /*while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            if (sg.contains(sink)) {
                int t = sg.index(sink);
                if (bfs.hasPathTo(t)) {
                    for (int v : bfs.pathTo(t)) {
                        System.out.println("    " + sg.name(v));
                    }
                } else {
                    System.out.println("not connected");
                }
            } else {
                System.out.println("not in database");
            }
        }*/
    }
}
