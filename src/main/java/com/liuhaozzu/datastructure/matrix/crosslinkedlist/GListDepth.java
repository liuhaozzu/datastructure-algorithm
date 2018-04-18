package com.liuhaozzu.datastructure.matrix.crosslinkedlist;

/**
 * Created by Administrator on 2018/4/17 0017.
 */
public class GListDepth {
    public int getDepth(GList list) {
        if (list == null) {
            return 1;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < list.length(); i++) {
            int dep = getDepth(list.get(i));
            if (dep > max) {
                max = dep;
            }
        }
        return max + 1;
    }
}
