package com.liuhaozzu.datastructure.graph.weightdigraph;

public interface SP {
    /**
     * 从顶点s到v的距离，如果不存在，则路径为无穷大
     * @param v
     * @return
     */
    double distTo(int v);

    /**
     * 是否存在从顶点s到v的路径
     * @param v
     * @return
     */
    boolean hasPathTo(int v);

    /**
     * 从顶点s到v的路径，如果不存在，返回null
     * @param v
     * @return
     */
    Iterable<DirectedEdge> pathTo(int v);

    boolean hasNegativeCycle();
}
