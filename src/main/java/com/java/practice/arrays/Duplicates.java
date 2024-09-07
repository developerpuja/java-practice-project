package com.java.practice.arrays;

public class Duplicates {
    public static void main(String[] args) {
        int [] arr = new int [] {1, 2, 3, 4, 2, 7, 8, 8, 3};

        for (int i = 0; i< arr.length-1; i++) {
            for (int j = i+1; j< arr.length-1; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate found for " + arr[i] + " at index " + j);
                }
            }
        }
        System.out.println(arr.length);
    }
}
