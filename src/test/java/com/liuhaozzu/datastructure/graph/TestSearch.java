package com.liuhaozzu.datastructure.graph;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestSearch {
    @Test
    public void graphConstractTest() throws IOException {
        Graph G = new Graph(new File("D:\\git-repos\\datastructure-algorithm\\src\\test\\resources\\graph\\tinyG.txt"));
        System.out.println(G.toString());
    }

    @Test
    public void searchTest() throws IOException {
        Graph G = new Graph(new File("D:\\git-repos\\datastructure-algorithm\\src\\test\\resources\\graph\\tinyG.txt"));
        System.out.println(G.toString());
        int s= 0;
        Search search = new DeepFirstSearch(G, s);
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v)) {
                System.out.print(v + " ");
            }
        }
        System.out.println();
        if (search.count() != G.V()) {
            System.out.print("NOT ");
        }
        System.out.println("connected");
    }
}
