package com.ranger.LearningJVM.ch3;

/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3M
 * PretenureSizeThreshold这个参数只对Serial和ParNew两款收集器有效
 */
public class TestPretenureAllocation {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation = new byte[4 * _1MB];
    }
}
