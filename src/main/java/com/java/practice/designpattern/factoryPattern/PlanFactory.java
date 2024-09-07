package com.java.practice.designpattern.factoryPattern;

public class PlanFactory {
    public static Plan getPlan(String planName) {
        return switch (planName) {
            case "IND" -> new IndustrialPlan();
            case "DOM" -> new DomesticPlan();
            case "COM" -> new CommercialPlan();
            default -> throw new IllegalArgumentException("Provide correct argument.");
        };
    }
}
