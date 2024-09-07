package com.java.practice.interview;

public abstract class AbstractClassTwo {
    private String name;

    public  AbstractClassTwo(String name) {
        this.name = name;
    }
    abstract void print();

    void testDefault() {
        System.out.println("Hello Puja.. from concrete method");
    }

    static void testStatic() {
        System.out.println("Hello from static method");
    }
}
