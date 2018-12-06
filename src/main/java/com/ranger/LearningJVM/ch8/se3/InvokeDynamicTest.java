package com.ranger.LearningJVM.ch8.se3;

import java.util.Arrays;

/**
 * 这里产生invokedynamic指令的方法与书上不同
 * 使用javap -verbose -p查看编译的字节码
 */
public class InvokeDynamicTest {
    public static void main(String[] args) {
        String[] strArr = new String[3];
        strArr[0] = "First";
        strArr[1] = "Second";
        strArr[2] = "Third";
        Arrays.stream(strArr).forEach(System.out::println);
        // 输出类型
        DynamicFunction<String[]> typeFunc = s -> s.getClass().getTypeName();
        System.out.println(typeFunc.describe(strArr));
        // 输出值
        DynamicFunction<String> valueFunc = s -> s;
        System.out.println(valueFunc.describe(strArr[0]));
    }

    /**
     * 定义一个函数应该是长什么样子的
     */
    @FunctionalInterface
    interface DynamicFunction<T> {
        String describe(T type);
    }
}
