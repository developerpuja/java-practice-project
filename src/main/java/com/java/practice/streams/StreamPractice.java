package com.java.practice.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        List<Employee> employees = Employee.getEmployeeList();
        findOutNumOfMaleAndFemaleEmp(employees);
        findAvgAgeOfMaleAndFemaleEmployee(employees);
        highestPaidEmployeeInTheOrg(employees);
        employeesJoinedAfter2015(employees);
        employeeCountInEachDepartment(employees);
        avgSalaryOfEachDepartment(employees);
        yougestEmployeeInProductDepartment(employees);
        mostWrokExpEmployee(employees);
        maleFemaleInSaleDepartment(employees);
        avarageSalaryOfMaleAndFemale(employees);
        empNameInEachDepartment(employees);
        sumOfSalariesOfEmployee(employees);
    }

    private static void sumOfSalariesOfEmployee(List<Employee> employees) {
        //Integer sum = employees.stream().map(Employee::getSalary).reduce(, Double::sum);
        Double sum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        Double sum1 = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(sum);
        System.out.println(sum1);
    }

    private static void empNameInEachDepartment(List<Employee> employees) {
        Map<String, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(map);
    }

    private static void avarageSalaryOfMaleAndFemale(List<Employee> employees) {
        Map<String, Double> map = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(map);
    }

    private static void maleFemaleInSaleDepartment(List<Employee> employees) {
        Map<String, Long> map = employees.stream().filter(employee -> employee.getDepartment().equals("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(map);
    }

    private static void mostWrokExpEmployee(List<Employee> employees) {
        Employee employee = employees.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).orElse(null);
        System.out.println(employee);
    }

    private static void yougestEmployeeInProductDepartment(List<Employee> employees) {
       Employee youngestEmployee =  employees.stream().filter(employee -> employee.getDepartment().equals("Product Development")).min(Comparator.comparingInt(Employee::getAge)).orElse(null);
        System.out.println(youngestEmployee);
    }

    private static void avgSalaryOfEachDepartment(List<Employee> employees) {
        Map<String, Double> map =   employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(map);
    }

    private static void employeeCountInEachDepartment(List<Employee> employees) {
        Map<String, Long> map = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(map);
    }

    private static void employeesJoinedAfter2015(List<Employee> employees) {
        System.out.println(employees.stream().filter(employee -> employee.getYearOfJoining() > 2015).toList());
    }

    private static void highestPaidEmployeeInTheOrg(List<Employee> employees) {
       Employee employee = employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
        System.out.println(employee);
    }


    private static void findAvgAgeOfMaleAndFemaleEmployee(List<Employee> employees) {
        Map<String, Double> list = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println(list);
    }

    private static void findOutNumOfMaleAndFemaleEmp(List<Employee> employees) {
        Map<String, Long> map = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(map);

        List<String> department = employees.stream().map(Employee::getDepartment).toList();
        System.out.println(department);
    }
}
