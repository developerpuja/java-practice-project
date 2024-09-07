package com.java.practice.designpattern.factoryPattern;

public class FactoryDPMethod {
    public static void main(String[] args) {
        Plan plan = PlanFactory.getPlan("IND");
        plan.executePlan("IND");
    }
}
