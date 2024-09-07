package com.java.practice.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

class Employee {
    public int id;
    public String name;
    public int departmentId;
    public Date dateOfBirth;
    public Employee(int id, String name, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
    public Employee(int id, String name, int departmentId) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.dateOfBirth = new GregorianCalendar(0,1,1).getTime();
    }

    int getAge(Date dob) {
        Date current = new Date();
        return  current.getYear()-dob.getYear();
    }
}
class Department {
    public int departmentId;
    public String departmentName;
    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
}
public class TestFaster {

    public static void main(String[] args) {
        List<Employee> myEmployees = List.of(
                new Employee(3, "David", new GregorianCalendar(1982,1,1).getTime()),
                new Employee(1, "Peter", new GregorianCalendar(1955,4,10).getTime()),
                new Employee(5, "Bob", new GregorianCalendar(1990,8, 8).getTime()),
                new Employee(7, "Mark", new GregorianCalendar(2000,12, 25).getTime()),
                new Employee(4, "Frank", new GregorianCalendar(1990,5, 6).getTime())
        );
        // find employee with the shortest name and output their id,name
        Employee employee = myEmployees.stream().collect(Collectors.minBy(Comparator.comparingInt(value -> value.name.length()))).orElse(null);
        System.out.println(employee.name +" " +employee.id);


        // find the average age of all employees
      // myEmployees.




        List<Department> departments = List.of(
                new Department(10, "IT"),
                new Department(20, "HR")
        );
        List<Employee> employees = List.of(
                new Employee(3, "David",10),
                new Employee(1, "Peter",10),
                new Employee(5, "Bob",10),
                new Employee(7, "Mark",20),
                new Employee(4, "Frank",20)
        );
        // SEARCH
        // find employee with id=7 and print what department he works in.
        Integer departmentId = employees.stream().filter(employee1 -> employee1.id == 7).map(employee1 -> employee1.departmentId).toList().stream().findFirst().orElse(0);

        System.out.println(departmentId);
        System.out.println("test");
    }
}