package com.liuhaozzu.datastructure.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bag<T> implements Iterable<T> {
    private final List<T> container = new ArrayList<>();
    public void add(T w) {
        container.add(w);
    }

    @Override
    public Iterator<T> iterator() {
        return container.iterator();
    }
}
