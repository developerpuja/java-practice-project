package com.java.practice.arrays;

/**
 * Java Program to print the elements of an array in reverse order
 */
public class ReverseArray {
    public static void main(String[] args) {
        int [] arr = new int [] {1, 2, 3, 4, 5};
        int[] revArr = new int[arr.length];
        int j = 0;
        for (int i = arr.length-1; i>=0; i--) {
            revArr[j] = arr[i];
            j++;
        }

        for (int k : revArr) {
            System.out.println(k);
        }
    }
}
