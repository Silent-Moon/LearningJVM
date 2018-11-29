package com.ranger.LearningJVM.ch7.se4;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream inputStream = getClass().getResourceAsStream(fileName);
                    if (inputStream == null) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object object = classLoader.loadClass("com.ranger.LearningJVM.ch7.se4.ClassLoaderTest").newInstance();
        System.out.println(object.getClass());
        // 测试instanceof关键字，计算机中存在两个ClassLoader类，一个是系统应用程序类加载器加载的，一个是我们自己编写的类加载器加载的
        System.out.println(object instanceof ClassLoaderTest);
    }
}
