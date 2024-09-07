package com.java.practice.arrays;

public class SmallestElement {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 100, 50, 56, 76, 9};
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Smallest Element: " + min);
    }
}
