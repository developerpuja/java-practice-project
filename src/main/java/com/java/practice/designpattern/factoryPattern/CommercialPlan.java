package com.java.practice.designpattern.factoryPattern;

public class CommercialPlan extends Plan{
    @Override
    void executePlan(String plan) {
        System.out.println("CommercialPlan executed");
    }
}
