package com.java.practice.designpattern.factoryPattern;

public class DomesticPlan extends Plan{
    @Override
    void executePlan(String plan) {
        System.out.println("DomesticPlan executed");
    }
}
