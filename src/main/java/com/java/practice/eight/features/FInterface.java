package com.java.practice.eight.features;

public class FInterface {
    public static void main(String[] args) {
        Vehicle vehicle = () -> {
            System.out.println("Hello there I am abstract method from functional class ");
        };

        vehicle.start();
    }
}
