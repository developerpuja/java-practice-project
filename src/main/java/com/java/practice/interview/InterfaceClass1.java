package com.java.practice.interview;

public interface InterfaceClass1 {
     String name = "PUJA";
    void testAbstractMethod();

    void print();

    static void staticMethod() {
        System.out.println("Hello from static");
    }

     default void defaultMethod() {
        System.out.println("Hello from default method");
     }
}
