package com.java.practice.eight.features;

public interface Vehicle {
    void start();

    default void method1() {
        System.out.println("From default method");
    }
}
