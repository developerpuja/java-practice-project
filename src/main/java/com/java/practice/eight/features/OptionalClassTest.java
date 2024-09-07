package com.java.practice.eight.features;

import java.util.Optional;

public class OptionalClassTest {
    public static void main(String[] args) {
        AllFeatures allFeatures = new AllFeatures();
        Optional<AllFeatures> allFeatures1 = Optional.of(allFeatures);
        allFeatures1.ifPresent(AllFeatures::practiceLambda);
    }
}
