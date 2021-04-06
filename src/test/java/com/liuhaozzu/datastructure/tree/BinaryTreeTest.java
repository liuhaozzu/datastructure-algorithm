package com.liuhaozzu.datastructure.tree;

import com.liuhaozzu.datastructure.tree.binarytree.BinaryNode;
import com.liuhaozzu.datastructure.tree.binarytree.BinaryTree;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2018/4/24 0024.
 */
public class BinaryTreeTest {
    
    private BinaryTree biTree = null;

    @Before
    public void setup() {
        BinaryNode root = new BinaryNode("-");
        root.setLt(new BinaryNode("+").setLt(new BinaryNode("a")).setRt(new BinaryNode("*").setLt(new BinaryNode("b")).setRt(new BinaryNode("-").setLt(new BinaryNode("c")).setRt(new BinaryNode("d")))));
        root.setRt(new BinaryNode("/").setLt(new BinaryNode("e")).setRt(new BinaryNode("f")));
        biTree = new BinaryTree(root);
    }

    @Test
    public void testPreOrderTraverse() {
        biTree.preOrderTraverse(biTree.getRoot());
    }

    @Test
    public void testInOrderTraverse() {
        biTree.inOrderTraverse(biTree.getRoot());
    }

    @Test
    public void testInOrderBraverseByStack() {
        biTree.inOrderBraverseByStack(biTree.getRoot());
    }

    @Test
    public void testInOrderBraverseByStack2() {
        biTree.inOrderBraverseByStack2(biTree.getRoot());
    }


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1000000);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (; ; ) {
                    System.out.println(Thread.currentThread().getName() + ":" + countDownLatch.getCount());
                    countDownLatch.countDown();
                    if (countDownLatch.getCount() == 0) {
                        break;
                    }
                }
            }).start();
        }
        countDownLatch.await();
        System.err.println("cost:" + (System.currentTimeMillis() - start));
    }

    @Test
    public void test1() throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getCanonicalHostName());

    }

    public void testMethod1() {
        int count = 1000;
        String[] arr = new String[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.toString(i);
        }
        String target = "999";

        System.out.println(Arrays.binarySearch(arr, target));

    }

    public void testMethod2() {
        int count = 1000;
        String[] arr = new String[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.toString(i);
        }
        String target = "999";

        for (int i = 0; i < count; i++) {
            if (target.equals(Integer.toString(i))) {
                System.out.println("find it :" + i);
                break;
            }
        }

    }
}
