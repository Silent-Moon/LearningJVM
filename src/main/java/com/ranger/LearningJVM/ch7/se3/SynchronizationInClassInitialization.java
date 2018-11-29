package com.ranger.LearningJVM.ch7.se3;

public class SynchronizationInClassInitialization {
    static class DeadLoopClass {
        static {
            // 如果不加上这个if语句，编译器将提示"Initializer does not complete normally"并拒绝编译
            if (true) {
                System.out.println(Thread.currentThread() + " init DeadLoopClass");
                // 一个线程将会一直等待
                while (true) ;
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread() + " start");
            DeadLoopClass deadLoopClass = new DeadLoopClass();
            System.out.println(Thread.currentThread() + " end");
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        // 两个线程在跑，但是DeadLoopClass的<clint>()方法只会被调用一次
        thread1.start();
        thread2.start();
    }
}
