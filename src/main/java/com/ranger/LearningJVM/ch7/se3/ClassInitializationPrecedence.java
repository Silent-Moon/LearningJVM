package com.ranger.LearningJVM.ch7.se3;

public class ClassInitializationPrecedence {
    static class Parent {
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        // 显示结果为2，因为父类的<clint>()先于子类执行
        System.out.println(Sub.B);
    }
}