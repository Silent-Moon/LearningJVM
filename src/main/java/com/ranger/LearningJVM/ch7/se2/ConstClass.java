package com.ranger.LearningJVM.ch7.se2;

/**
 * Created by q4667 on 2018/11/27.
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init.");
    }

    public static final String HELLO_WORLD = "Hello world!";
}
