package com.ranger.LearningJVM.ch8.se3;

import java.io.Serializable;

/**
 * 演示选择“更加合适”的版本的方法
 * 依次注释
 * 1. sayHello(char arg)
 * 2. sayHello(int arg)
 * 3. sayHello(long arg)
 * 4. sayHello(Character arg)
 * 5. sayHello(Serializable arg)
 * 6. sayHello(Object arg)
 * 7. sayHello(char... arg)
 * 观察结果变化
 */
public class Overload {
    public static void sayHello(Object arg) {
        System.out.println("Hello, Object");
    }

    public static void sayHello(int arg) {
        System.out.println("Hello, int");
    }

    public static void sayHello(long arg) {
        System.out.println("Hello, long");
    }

    public static void sayHello(Character arg) {
        System.out.println("Hello, Character");
    }

    public static void sayHello(char arg) {
        System.out.println("Hello, char");
    }

    public static void sayHello(char... arg) {
        System.out.println("Hello, char...");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("Hello, Serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
