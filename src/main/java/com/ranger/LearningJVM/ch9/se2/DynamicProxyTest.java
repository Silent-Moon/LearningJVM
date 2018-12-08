package com.ranger.LearningJVM.ch9.se2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {
        @Override
        public void sayHello() {
            System.out.println("Hello world!");
        }
    }

    static class DynamicProxy implements InvocationHandler {
        private Object originalObject;

        Object bind(Object originalObject) {
            this.originalObject = originalObject;
            return Proxy.newProxyInstance(originalObject.getClass().getClassLoader(), originalObject.getClass().getInterfaces(), this);
        }

        /**
         * 所有的proxy实例方法都会经过这个方法
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Welcome to Java!");
            return method.invoke(originalObject, args);
        }
    }

    public static void main(String[] args) {
        // 下面这段话输出产生的代理类，路径是项目根目录下面的com\ranger\LearningJVM\ch9
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IHello hello = new Hello();
        IHello proxyObj = (IHello) new DynamicProxy().bind(hello);
        // 以下注释掉的是简化版，注释掉是为了缩减javap的输出
//        ((IHello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(),
//                ((proxy, method, arguments) -> {
//                    System.out.println("Welcome to Java!");
//                    return method.invoke(hello, arguments);
//                }))).sayHello();
        proxyObj.sayHello();
    }
}
