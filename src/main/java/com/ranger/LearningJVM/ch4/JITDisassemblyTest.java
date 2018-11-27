package com.ranger.LearningJVM.ch4;

/**
 * -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -Xcomp -XX:CompileCommand=dontinline,*JITDisassemblyTest.sum -XX:CompileCommand=compileonly,*JITDisassemblyTest.sum JITDisassemblyTest
 * 使用插件查看JIT编译的结果需要手动编译JDK的部分源码
 * */
public class JITDisassemblyTest {
    int a = 1;
    static int b = 2;

    public int sum(int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        new JITDisassemblyTest().sum(3);
    }
}
