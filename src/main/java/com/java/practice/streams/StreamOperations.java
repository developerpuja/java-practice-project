package com.java.practice.streams;

import java.util.*;
import java.util.stream.Collectors;


public class StreamOperations {

    public static void main(String[] args) {
        List<Employee> employeeList = Employee.getEmployeeList();
        // separateEmployeeAgeWise(employeeList);
        //oldestEmployeeDetail(employeeList);
        //averageAndTotalSalaryOfAllDepartment(employeeList);
        //listOfNamesOfEachDepartmentEmp(employeeList);
        //averageSalaryOfMaleFemale(employeeList);
         //femaleAndMaleEmployeesInSalesDepartment(employeeList);
        //mostWorkExperienceEmployee(employeeList);
       // youngestFemaleEmployee(employeeList);
        //youngestEmployee(employeeList);
        //averageSalaryOfEachDepartment(employeeList);
        //eachDepartmentEmployeeCount(employeeList);
        //employeesJoined();
        //highestPaidEmployee();
        //averageAgeOfEmployee();
       // streamOperations.femaleEmployees();
       // streamOperations.nameOfAllDepartment();
       // toUpperCase();
        //sortDescOrder();
        //distinctNumber();
       // reduceIntToSum();
        //extractFirstNameFromFullName();
        //mergeTwoList();
        skipElements();
        convertListToSet();
    }

    private static void convertListToSet() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 2, 5);
        Set<Integer> set =  numbers.stream().collect(Collectors.toSet());
        System.out.println(set);
    }

    private static void skipElements() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 2, 5);
        List<Integer> numbers1 = numbers.stream().skip(2).toList();
        System.out.println(numbers1);
    }

    private static void mergeTwoList() {
        List<List<Integer>> nestedNumbers = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5));
        List<Integer> mergedElement = nestedNumbers.stream().flatMap(List::stream).toList();
        System.out.println(mergedElement);
    }

    private static void extractFirstNameFromFullName() {
        List<String> fullNames = Arrays.asList("Alice Johnson", "Bob Harris", "Charlie Lou");
        List<String> firstName = fullNames.stream().map(s -> s.split(" ")[0]).toList();
        System.out.println(firstName);

    }

    private static void reduceIntToSum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 2, 5);
        Integer sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    private static void distinctNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 2, 5);
        List<Integer> sorted = numbers.stream().distinct().toList();
        Integer any = numbers.stream().findAny().orElse(null);
        System.out.println(any);
        //System.out.println(sorted);
    }

    private static void sortDescOrder() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 2, 5);
        List<Integer> sortedNum = numbers.stream().sorted().toList();
        System.out.println(sortedNum);
    }

    private static void separateEmployeeAgeWise(List<Employee> employeeList) {
        List<Employee> employees = employeeList.stream().filter(employee -> employee.getAge() <= 25).toList();
        List<Employee> employees1 = employeeList.stream().filter(employee -> employee.getAge() > 25).toList();
        System.out.println("*********** 25 or younger age   ***********");
        System.out.println(employees);
        System.out.println("***********  more than 25 age   ***********");
        System.out.println(employees1);
    }

    private static void oldestEmployeeDetail(List<Employee> employeeList) {
        Employee employee = employeeList.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null);
        System.out.println(employee);
    }

    private static void averageAndTotalSalaryOfAllDepartment(List<Employee> employeeList) {
        DoubleSummaryStatistics statistics = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average Salary:" + statistics.getAverage());
        System.out.println("Total Salary:" + statistics.getSum());
    }

    private static void listOfNamesOfEachDepartmentEmp(List<Employee> employeeList) {
        Map<String, List<String>> names = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        Map<String, List<Employee>> listMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(listMap);
        System.out.println(names);
    }

    private static void averageSalaryOfMaleFemale(List<Employee> employeeList) {
       Map<String, Double> salaryMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(salaryMap);
    }

    private static void femaleAndMaleEmployeesInSalesDepartment(List<Employee> employeeList) {
        Map<String, Long> femaleMaleCount = employeeList.
                stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(femaleMaleCount);
    }

    private static void mostWorkExperienceEmployee(List<Employee> employeeList) {
        Employee employee = employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).orElse(null);
        System.out.println(employee);
    }

    private static void youngestFemaleEmployee(List<Employee> employeeList) {
        Employee employee = employeeList.stream().filter(employee1 -> employee1.getDepartment().equalsIgnoreCase("Product Development")).filter(employee1 -> employee1.getGender().equalsIgnoreCase("male")).min(Comparator.comparingDouble(Employee::getAge)).orElse(null);
        System.out.println(employee);
    }

    private static void youngestEmployee(List<Employee> employeeList) {
        Employee employee = employeeList.stream().min(Comparator.comparingInt(Employee::getAge)).orElse(null);
        System.out.println(employee);
    }

    private static void averageSalaryOfEachDepartment(List<Employee> employeeList) {
        Map<String, Double> averageSalaryOfEachDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(averageSalaryOfEachDepartment);
    }

    private static void eachDepartmentEmployeeCount(List<Employee> employeeList) {
        Map<String, Long> departmentEmpCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(departmentEmpCount);
    }


    public static void femaleEmployees() {
        List<Employee> femaleEmployeeList = Employee.getEmployeeList().stream().filter(employee1 -> employee1.getGender().equalsIgnoreCase("female")).toList();
        long femaleCount = femaleEmployeeList.size();
        List<Employee> maleEmployeeList = Employee.getEmployeeList().stream().filter(employee1 -> employee1.getGender().equalsIgnoreCase("male")).toList();
        //femaleEmployeeList.forEach(System.out::println);
        System.out.println("******************************************************************************************************************");
        //maleEmployeeList.forEach(System.out::println);

        Map<String, Long> maleFemaleCount = Employee.getEmployeeList().stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(maleFemaleCount);
    }

    public static void nameOfAllDepartment() {
        List<String> departmentNames = Employee.getEmployeeList().stream().map(Employee::getDepartment).distinct().toList();
        departmentNames.forEach(System.out::println);
    }

    public static void averageAgeOfEmployee() {
        Map<String, Double> averageAge = Employee.getEmployeeList().stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(averageAge);
    }


    public static void highestPaidEmployee() {
        Employee employee = Employee.getEmployeeList().stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
        System.out.println(employee);
    }

    public static void employeesJoined() {
        List<String> employeeNames = Employee.getEmployeeList().stream().filter(employee -> employee.getYearOfJoining() > 2015).map(Employee::getName).toList();
        System.out.println(employeeNames);
    }

    public static void toUpperCase() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }

}
