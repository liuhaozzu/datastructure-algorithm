package com.liuhaozzu.datastructure.tree.binarytree;

/**
 * Created by Administrator on 2018/4/24 0024.
 */
public class TreeNode<T> {

    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T data){
        this(data, null, null);
    }
    
    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right){
        this.value = value;
        this.setLeft(left);
        this.setRight(right);
    }

    public TreeNode<T> getRight() {
        return right;
    }
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
    public TreeNode<T> getLeft() {
        return left;
    }
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
