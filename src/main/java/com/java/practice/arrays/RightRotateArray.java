package com.java.practice.arrays;

public class RightRotateArray {
    public static void main(String[] args) {
        int [] arr = new int [] {1, 2, 3, 4, 5};
        System.out.println("Original array");
        for (int i : arr)
            System.out.print(i + " ");
        int last = arr[arr.length-1];

        for (int i = arr.length-1 ; i > 0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = last;

        System.out.println("Rotated array");
        for (int i : arr)
            System.out.print(i + " ");
    }


}
