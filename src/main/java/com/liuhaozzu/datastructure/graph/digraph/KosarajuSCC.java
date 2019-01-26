package com.liuhaozzu.datastructure.graph.digraph;

/**
 * Kosaraju算法
 * 1，在给定的一幅有向图G中，使用DepthFirstOrder来计算它的反向图GR的逆后序排列
 * 2，在G中进行标准的深度优先搜索，但是要按照刚才计算得到的顺序而非标准的顺序来访问所有未被标记的顶点
 * 3，在构造函数中，所有在同一个递归dfs（）调用中被访问到的顶点都在同一个强连通分量重，将他们按照和CC相同的方式识别出来
 *
 */
public class KosarajuSCC {
    private boolean[] marked;//已访问过的顶点
    private int[] id;//强连通分量的标识符
    private int count;//强连通分量的数量
    public KosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        for (int s : order.reversePost()) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    /**
     * v 和 w是强连通的吗
     * @param v
     * @param w
     * @return
     */
    boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    /**
     * 图中的强连通分量的总数
     * @return
     */
    int count() {
        return count;
    }

    /**
     * v所在的强连通分量的标识符（在0到count()-1之间
     * @param v
     * @return
     */
    int id(int v) {
        return id[v];
    }
}
