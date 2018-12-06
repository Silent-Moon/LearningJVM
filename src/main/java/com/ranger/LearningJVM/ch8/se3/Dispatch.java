package com.ranger.LearningJVM.ch8.se3;

/**
 * 单分派、多分派演示
 */
public class Dispatch {
    static class QQ {
    }

    static class _360 {
    }

    static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("Father chooses QQ");
        }

        public void hardChoice(_360 arg) {
            System.out.println("Father chooses 360");
        }
    }

    static class Son extends Father {
        public void hardChoice(QQ arg) {
            System.out.println("Son chooses QQ");
        }

        public void hardChoice(_360 arg) {
            System.out.println("Son chooses 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}
