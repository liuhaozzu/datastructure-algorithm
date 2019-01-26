package com.liuhaozzu.datastructure.tree.binarytree;

import java.util.Stack;

/**
 * Created by Administrator on 2018/4/18 0018.
 * character:
 * 1, there are at most 2^(i-1) nodes at layer i
 * 2, there are at most 2^i - 1 nodes in a tree with depth = i;
 * 3, 对任何一棵二叉树T，如果其终端节点数为n，度为2的节点数m， 则 n = m+1
 */
public class BinaryTree<T extends Comparable<? extends T>> {

    private BinaryNode root;

    public BinaryTree(BinaryNode root) {
        this.root = root;
    }

    public void preOrderTraverse(BinaryNode root) {
        if (root != null) {
            System.out.print(root.toString());
            preOrderTraverse(root.getLt());
            preOrderTraverse(root.getRt());
        }
    }
    public void inOrderTraverse(BinaryNode root) {
        if (root != null) {
            inOrderTraverse(root.getLt());
            System.out.print(root.toString());
            inOrderTraverse(root.getRt());
        }
    }

    public void inOrderBraverseByStack(BinaryNode root){
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (stack.peek() != null) {
                stack.push(stack.peek().getLt());
            }
            BinaryNode p = stack.pop();
            if (!stack.isEmpty()) {
                p =stack.pop();
                if (p.getData() != null) {
                    System.out.print(p.getData());
                }
                stack.push(p.getRt());
            }
        }
    }

    public void inOrderBraverseByStack2(BinaryNode root){
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode p = root;
        while (p!=null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.getLt();
            } else {
                p = stack.pop();
                if (p.getData() != null) {
                    System.out.println(p.getData());;
                }
            }
        }
    }

    public void postOrderTraverse(BinaryNode root) {
        if (root != null) {
            postOrderTraverse(root.getLt());
            postOrderTraverse(root.getRt());
            System.out.print(root.toString());
        }
    }

    public BinaryNode getRoot() {
        return root;
    }

    public BinaryTree setRoot(BinaryNode root) {
        this.root = root;
        return this;
    }
}
