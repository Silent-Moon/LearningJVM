package com.ranger.LearningJVM.ch4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 使用Visual VM的BTrace插件测试
 */
public class BTraceTest {
    private int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        BTraceTest test = new BTraceTest();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            br.readLine();
            int a = (int) Math.round(Math.random() * 1000);
            int b = (int) Math.round(Math.random() * 1000);
            System.out.println(test.add(a, b));
        }
    }
}

// 将以下代码反注释后粘贴到BTrace console

//import com.sun.btrace.annotations.*;
//import static com.sun.btrace.BTraceUtils.*;
//
//@BTrace
//public class TracingScript {
//    @OnMethod(clazz="com.ranger.LearningJVM.ch4.BTraceTest", method="add", location=@Location(Kind.RETURN))
//    public static void func(@Self com.ranger.LearningJVM.ch4.BTraceTest instance, int a, int b, @Return int result) {
//        println("调用堆栈：");
//        jstack();
//        println(strcat("方法参数A: ", str(a)));
//        println(strcat("方法参数B: ", str(b)));
//        println(strcat("方法结果: ", str(result)));
//    }
//}