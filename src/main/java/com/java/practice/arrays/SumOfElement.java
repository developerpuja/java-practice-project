package com.java.practice.arrays;

public class SumOfElement {
    public static void main(String[] args) {
        int [] arr = new int [] {1, 2, 3, 4, 2, 7, 8, 8, 3};
        int sum = 0;

        for (int i : arr) {
            sum = sum+i;
        }

        System.out.println("Sum of all elements: " + sum);
    }
}
