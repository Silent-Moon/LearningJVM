package com.ranger.LearningJVM.ch4;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms100m -Xmx100m -XX:+UseSerialGC
 * 使用JConsole监控
 */
public class MemoryMonitoring {
    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 稍做延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    static class OOMObject {
        // 占位对象，大小约为64KB
        public byte[] placeHolder = new byte[64 * 1024];
    }
}
