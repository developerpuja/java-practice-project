package com.java.practice.Test;


public class TestClass {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 3, 6}; // {6, 3, 7, 5, 2}

        int lastInd = arr.length-1;

       for(int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[lastInd];
            arr[lastInd] = temp;
            lastInd--;
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }



}
