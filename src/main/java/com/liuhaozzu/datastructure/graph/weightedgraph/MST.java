package com.liuhaozzu.datastructure.graph.weightedgraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public interface MST {
    /*MST(EdgeWeightedGraph G) {

    }*/

    /**
     * 最小生成树的所有边
     * @return
     */
    Iterable<Edge> edges() ;

    /**
     * 最小生成树的权重
     * @return
     */
    double weight() ;

    /*public static void main(String[] args) throws FileNotFoundException {
        String filename = "";
        BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
        EdgeWeightedGraph G = new EdgeWeightedGraph(reader);
        MST mst = new MST(G);
        for (Edge edge : mst.edges()) {
            System.out.println(edge);
        }
        System.out.println(mst.weight());
    }*/
}
