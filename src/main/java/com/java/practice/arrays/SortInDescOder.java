package com.java.practice.arrays;

public class SortInDescOder {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 100, 50, 56, 76, 9};
        int temp;

        for (int i = 0; i<= arr.length ; i++)  {
            for (int j = i+1; j< arr.length; j++) {
                if (arr[i]< arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for (int i = 0; i<= arr.length-1 ; i++)  {
            System.out.println(arr[i]);
        }
    }
}
