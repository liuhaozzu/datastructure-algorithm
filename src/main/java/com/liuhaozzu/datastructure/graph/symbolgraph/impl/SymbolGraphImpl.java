package com.liuhaozzu.datastructure.graph.symbolgraph.impl;

import com.liuhaozzu.datastructure.graph.Graph;
import com.liuhaozzu.datastructure.graph.symbolgraph.SymbolGraph;
import edu.princeton.cs.algs4.StdIn;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SymbolGraphImpl implements SymbolGraph {

    private Map<String, Integer> st;//符号名  索引
    private String[] keys;// 索引 符号名
    private Graph G;//图
    private String stream;


    public SymbolGraphImpl(String stream, String sp) throws IOException {
        st = new HashMap<>();
        this.stream = stream;
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(new File(stream)));
            while ((line = reader.readLine()) != null) {
                String[] a = line.split(sp);
                for (int i = 0; i < a.length; i++) {//为每个不同的字符串关联一个索引
                    if (!st.containsKey(a[i])) {
                        st.put(a[i], st.size());
                    }
                }
            }
            keys = new String[st.size()];//用来获取顶点名的反向索引
            for (String name : st.keySet()) {
                keys[st.get(name)] = name;
            }
            G = new Graph(st.size());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader != null) {
                reader.close();
            }
        }

        System.out.println("first read success");

        BufferedReader reader2 = new BufferedReader(new FileReader(new File(stream)));

        while ((line = reader2.readLine()) != null) {
            String[] a = line.split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                G.addEdge(v, st.get(a[i]));
            }
        }
        System.out.println("second read success");

        System.out.println(G.getClass());
    }


    @Override
    public boolean contains(String s) {
        return st.containsKey(s);
    }

    @Override
    public int index(String s) {
        return st.get(s);
    }

    @Override
    public String name(int v) {
        return keys[v];
    }

    @Override
    public Graph G() {
        return G;
    }



    public static void main(String[] args) throws IOException {
        String filename = "D:\\git-repos\\datastructure-algorithm\\src\\main\\resources\\symbolgraph\\movies.txt";
        String delimi = "\\/";
        SymbolGraphImpl sg = new SymbolGraphImpl(filename, delimi);
        Graph G = sg.G();
        System.out.println(G.V());

        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            for (int w : G.adj(sg.index(source))) {
                System.out.println("    "+sg.name(w));
            }
        }
            /*String source = "'Breaker' Morant (1980)";
            for (int w : G.adj(sg.index(source))) {
                //System.out.println("w:" + w);;
                System.out.println("    "+sg.name(w));
            }*/

    }
}
