package com.liuhaozzu.datastructure.graph.path;

/**
 * 在G中找出所有起点为S的路径
 */
public interface Paths {
    /**
     * 是否存在从S到V的路径
     * @param v
     * @return
     */
    boolean hasPathTo(int v);

    /**
     * s到v的路径，如果不存在，返回null
     * @param v
     * @return
     */
    Iterable<Integer> pathTo(int v);
}
