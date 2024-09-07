package com.java.practice.arrays;

public class SortAscOrder {
    public static void main(String[] args) {
        int [] arr =  new int [] {5, 9, 1, 2, 3, 4, 2, 7, 8, 8, 3};

        for (int i = 0 ; i< arr.length-1; i++) {
            if (arr[i] > arr[i + 1]) {
                arr[i] = arr[i + 1];
            }
        }
        for (int i : arr)
            System.out.print(i+" ");
    }
}
