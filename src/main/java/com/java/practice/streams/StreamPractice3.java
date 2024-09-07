package com.java.practice.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice3 {
    public static void main(String[] args) {
        List<Employee> employees = Employee.getEmployeeList();
        findOddAndEvenNumSumOfAges(employees);
        groupAListOfEmployeeByTheirNameLength(employees);
    }

    private static void groupAListOfEmployeeByTheirNameLength(List<Employee> employees) {
        Map<Integer, List<String>> map = employees.stream().map(Employee::getName).collect(Collectors.groupingBy(String::length));
        System.out.println(map);
    }

    private static void findOddAndEvenNumSumOfAges(List<Employee> employees) {
        Map<String, Integer> map = employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getAge()%2==0, Collectors.summingInt(Employee::getAge)))
                .entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey() ? "Even":"Odd", Map.Entry::getValue));
        System.out.println(map);

    }
}
