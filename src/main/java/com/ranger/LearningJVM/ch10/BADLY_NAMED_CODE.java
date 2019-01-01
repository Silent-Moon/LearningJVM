package com.ranger.LearningJVM.ch10;

/**
 * 首先build project，然后执行以下命令以观察输出结果
 * javac -encoding utf8 -classpath target/classes -processor com.ranger.LearningJVM.ch10.NameCheckProcessor -d target/classes src/main/java/com/ranger/LearningJVM/ch10/BADLY_NAMED_CODE.java
 */
public class BADLY_NAMED_CODE {
    enum colors {
        red, blue, green;
    }

    static final int _FORTY_TWO = 42;

    public static int NOT_A_CONSTANT = _FORTY_TWO;

    protected void BADLY_NAMED_CODE() {
        return;
    }

    public void NOTcamelCASEmethodNAME() {

    }
}
