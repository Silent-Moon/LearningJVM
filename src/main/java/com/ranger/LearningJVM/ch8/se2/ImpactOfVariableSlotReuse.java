package com.ranger.LearningJVM.ch8.se2;

/**
 * -verbose:gc
 */
public class ImpactOfVariableSlotReuse {
    public static void main(String[] args) {
        {
            byte[] placeHolder = new byte[8 * 1024 * 1024];
        }
        // 注释掉下面这行后GC没有任何效果，因为variable slot还存在对placeHolder的值的引用，而variable slot是GC root的一部分
        int a = 0;
        System.gc();
    }
}
