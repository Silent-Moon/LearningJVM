package com.ranger.LearningJVM.ch6;

/**
 * 使用javap -verbose 处理编译之后的文件
 */
public class TestClass {
    private int m;

    public int inc() {
        return m + 1;
    }

    public int increment() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception ex) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }
}
