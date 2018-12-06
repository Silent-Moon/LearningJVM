package com.ranger.LearningJVM.ch8.se3;

/**
 * 方法静态解析演示
 * 使用javap -verbose观察细节
 */
public class StaticResolution {
    public static void sayHello() {
        System.out.println("Hello world!");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
}
