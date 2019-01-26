package com.liuhaozzu.datastructure.graph.cc;

public interface CC {
    /**
     * v 和 w 联通吗
     * @param v
     * @param w
     * @return
     */
    boolean connected(int v, int w);

    /**
     * 联通分量数
     * @return
     */
    int count();

    /**
     * v 所在的联通分量的标识符（0~count()-1）
     * @param v
     * @return
     */
    int id(int v);
}
