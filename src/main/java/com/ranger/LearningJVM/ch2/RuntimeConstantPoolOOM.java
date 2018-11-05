package com.ranger.LearningJVM.ch2;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 */
public class RuntimeConstantPoolOOM {
//    // 以下测试只能在JDK1.6中，输入参数为-XX:PermSize=10M -XX:MaxPermSize=10M, JDK1.8中这两个参数已经被移除，另外，1.8中不会有异常抛出
//    public static void main(String[] args) {
//        // 使用List保持着常量池引用，避免Full GC回收常量池行为
//        List<String> list = new ArrayList<>();
//        // 10MB的PermSize在integer范围内足够产生OOM了
//        int i = 0;
//        while (true) {
//            list.add(String.valueOf(i++).intern());
//        }
//    }

    // 以下代码在1.6和1.6+的JDK中有不同的输出，具体请参考书中内容
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
