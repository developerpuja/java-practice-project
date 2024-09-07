package com.java.practice.eight.features;

import java.util.function.Function;
import java.util.function.Predicate;

public class AllFeatures {
    public static void main(String[] args) {
        // Lambda exp
       // practiceLambda();
    }

    public void practiceLambda() {
        Vehicle vehicle = () -> System.out.println("Hello there");
        vehicle.start();
        vehicle.method1();

        Predicate<Integer> predicate = (a) -> a>10;
        System.out.println(predicate.test(4));

        Function<String, Integer> function = String::length;
        System.out.println(function.apply("puja"));
    }
}
