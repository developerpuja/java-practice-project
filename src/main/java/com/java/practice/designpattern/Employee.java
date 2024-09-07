package com.java.practice.designpattern;

import lombok.Builder;
import lombok.ToString;

@ToString
public class Employee {
    private String name;
    private String designation;

    public Employee(EmployeeBuilder employeeBuilder) {
        this.name = employeeBuilder.name;
        this.designation = employeeBuilder.designation;
    }

    public static class EmployeeBuilder {
        private String name;
        private String designation;
            public EmployeeBuilder name(String name1) {
             this.name = name1;
             return this;
            }

            public EmployeeBuilder designation(String designation1) {
                this.designation = designation1;
                return this;
            }


            public Employee build() {
                return new Employee(this);
            }


    }

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

}
