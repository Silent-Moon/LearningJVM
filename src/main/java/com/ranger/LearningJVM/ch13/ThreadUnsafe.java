package com.ranger.LearningJVM.ch13;

import java.util.Vector;

public class ThreadUnsafe {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }
            Thread removeThread = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            });
            Thread printThread = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println(vector.get(i));
                }
            });

            removeThread.start();
            printThread.start();

            // 不要同时产生过多线程，否则会导致操作系统假死
            while (Thread.activeCount() > 10) ;
        }
    }
}
