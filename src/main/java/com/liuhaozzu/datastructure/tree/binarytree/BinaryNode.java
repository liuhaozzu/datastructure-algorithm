package com.liuhaozzu.datastructure.tree.binarytree;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2018/4/24 0024.
 */
public class BinaryNode<T> {

    private Object data;
    private BinaryNode lt;
    private BinaryNode rt;

    public BinaryNode(T data){
        this(data, null, null);
    }
    public BinaryNode(T data, BinaryNode lt, BinaryNode rt){
        this.data = data;
        this.lt=lt;
        this.rt=rt;
    }

    public Object getData() {
        return data;
    }

    public BinaryNode setData(Object data) {
        this.data = data;
        return this;
    }

    public BinaryNode getLt() {
        return lt;
    }

    public BinaryNode setLt(BinaryNode lt) {
        this.lt = lt;
        return this;
    }

    public BinaryNode getRt() {
        return rt;
    }

    public BinaryNode setRt(BinaryNode rt) {
        this.rt = rt;
        return this;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
