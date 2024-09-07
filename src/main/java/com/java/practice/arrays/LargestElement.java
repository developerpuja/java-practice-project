package com.java.practice.arrays;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr = new int[] {30, 50, 56, 76, 89};
        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println("Largest element:" + max);

    }
}
