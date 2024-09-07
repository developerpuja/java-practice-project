package com.java.practice.designpattern.builder;


import com.java.practice.designpattern.Employee;

public class BuilderDesignPattern {
    public static void main(String[] args) {
        Employee employee = Employee.builder().name("puja").designation("SE").build();
        System.out.println(employee);
    }
}
