package com.liuhaozzu.datastructure.gc;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class PigThroughput {
    static volatile List pigs = Lists.newArrayList();
    static volatile int pigsEaten = 0;
    static final int ENOUTH_PIGS = 5000;

    public static void main(String[] args) {
        new PigEater().start();
        new PigDigester().start();
    }

    private static class PigEater extends Thread {
        @Override
        public void run() {
            while (true) {
                pigs.add(new byte[32 * 1024 * 10]);
                if (pigsEaten > ENOUTH_PIGS) {
                    return;
                }
                takeANap(1);
            }
        }
    }

    private static class PigDigester extends Thread {
        @Override
        public void run() {
            long start = System.currentTimeMillis();
            while (true) {
                takeANap(20);
                pigsEaten += pigs.size();
                System.out.println(pigsEaten);
                pigs = new ArrayList();
                if (pigsEaten > ENOUTH_PIGS) {
                    long duration = System.currentTimeMillis() - start;
                    System.out.format("Digested %d pigs in %d ms.", pigsEaten, duration);
                    System.out.println(new Double(pigsEaten) / new Double(duration));
                    return;
                }
            }
        }
    }

    private static void takeANap(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
