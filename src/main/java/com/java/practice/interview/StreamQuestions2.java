package com.java.practice.interview;


import java.util.*;
import java.util.stream.Collectors;

public class StreamQuestions2 {
    public static void main(String[] args) {
        List<Employee> list = Employee.getEmployeeList();
        sortEmployeeBasedOnId(list);
        sortEmployeeBasedOnIdReverse(list);
        sortEmployeeBasedName(list);
        sortEmployeeBasedOnIdAndName(list);
        maxAgeOfEmployee(list);
        testEmpMap(list);
    }

    private static void testEmpMap(List<Employee> list) {
        Map<Integer, List<String>> empMap = list.stream().collect(Collectors.toMap(Employee::getId, emp1->Arrays.asList(emp1.getName(), emp1.getDepartment(), emp1.getGender())));
    }

    private static void maxAgeOfEmployee(List<Employee> list) {
        Integer age = list.stream().map(Employee::getAge).max(Comparator.naturalOrder()).orElse(null);
        System.out.println(age);
    }

    private static void sortEmployeeBasedOnIdAndName(List<Employee> list) {
        List<Employee> sorted = list.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getId)).toList();
        System.out.println(sorted);
    }

    private static void sortEmployeeBasedOnIdReverse(List<Employee> list) {
        List<Employee> sorted = list.stream().sorted(Comparator.comparingInt(Employee::getId).reversed()).toList();
        System.out.println(sorted);
    }

    private static void sortEmployeeBasedName(List<Employee> list) {
        List<Employee> sorted = list.stream().sorted(Comparator.comparing(Employee::getName)).toList();
        System.out.println(sorted);
    }

    private static void sortEmployeeBasedOnId(List<Employee> list) {
        List<Employee> sortedList = list.stream().sorted(Comparator.comparingInt(Employee::getId)).toList();
        System.out.println(sortedList);
    }
}
