package com.ranger.LearningJVM.ch4;

/**
 * 使用JConsole监控
 */
public class DeadLockThreadMonitoring {
    public static void main(String[] args) {
        // 用循环确保一次运行会出现死锁
        for (int i = 0; i < 100; i++) {
            new Thread(new SyncAddRunnable(1, 2)).start();
            new Thread(new SyncAddRunnable(2, 1)).start();
        }
    }

    static class SyncAddRunnable implements Runnable {
        int a, b;

        public SyncAddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            // Integer会缓存[-128, 127]的数值，具体请参看源码Integer.IntegerCache
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }
}
