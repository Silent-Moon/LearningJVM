package com.ranger.LearningJVM.ch7.se3;

public class IllegalForwardReference {
    static {
        // 可以赋值，不能引用
        i = 0;
        // 反注释下面这段话会提示illegal forward reference
//        System.out.println(i);
    }

    static int i = 1;
}
