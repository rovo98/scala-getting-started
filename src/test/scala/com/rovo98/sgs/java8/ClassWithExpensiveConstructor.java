package com.rovo98.sgs.java8;

public class ClassWithExpensiveConstructor {
    private final int value;

    private ClassWithExpensiveConstructor() {
        value = doExpensiveLookup();
    }

    private int doExpensiveLookup() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        return 1;
    }

    public int getValue() {
        return value;
    }
}
