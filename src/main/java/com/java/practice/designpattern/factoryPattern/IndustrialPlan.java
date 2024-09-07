package com.java.practice.designpattern.factoryPattern;

public class IndustrialPlan extends Plan {
    @Override
    void executePlan(String plan) {
        System.out.println("IndustrialPlan executed");
    }
}
