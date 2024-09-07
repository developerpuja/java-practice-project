package com.java.practice.arrays;

public class EvenPositionElement {
    public static void main(String[] args) {
        int [] arr = new int [] {1, 2, 3, 4, 2, 7, 8, 8, 3};
        // even by index
        for (int i = 0 ; i< arr.length ; i++){
            if (i % 2 == 0)
                System.out.println(arr[i] + " this is at even position");
        }
        System.out.println("**************************************************");
        // even by normal position
        for (int i = 1; i< arr.length; i = i+2){
            System.out.println(arr[i] + " this is at even position");
        }
    }
}
