package com.ranger.LearningJVM.ch8.se3;

/**
 * 方法静态分派演示
 * 重载是通过参数的静态类型而不是实际类型作为判定依据的
 */
public class StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human human) {
        System.out.println("Hello, guy!");
    }

    public void sayHello(Man man) {
        System.out.println("Hello, gentleman!");
    }

    public void sayHello(Woman woman) {
        System.out.println("Hello, lady!");
    }

    public static void main(String[] args) {
        // 实际类型变化
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
        // 静态类型变化
        sr.sayHello((Man) man);
        sr.sayHello((Woman) woman);
    }
}
