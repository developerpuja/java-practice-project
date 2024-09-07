package com.java.practice.logical;

import java.util.HashMap;
import java.util.Map;

public class ArrayPrograms {
    public static void main(String[] args) {
        copyOneArrayToOther();
        findFrequencyOfEachElementInArray();
        leftRotateArray();
        rightRotateArray();
    }

    private static void rightRotateArray() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int j; int last = arr[arr.length-1];
        for (j = arr.length-1; j>0; j--) {
            arr[j] = arr[j-1];
        }
        arr[j] = last;
        for (int i = 0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void leftRotateArray() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8,5, 6, 7};
        int i ; int first = arr[0];
        for (i = 0; i< arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[i] = first;

        for (i = 0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /*
       1. use HashMap
       2. use new Array for freq
     */
    private static void findFrequencyOfEachElementInArray() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8,5, 6, 7};

        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] freqArr = new int[arr.length];


        for (int k : arr) {
            freqMap.put(k, freqMap.getOrDefault(k, 0) + 1);
        }
        System.out.println(freqMap);

        for (int i = 0; i< arr.length; i++){
            int count = 1;
            for (int j = i+1; j<arr.length; j++) {
                if (arr[i] == arr[j]){
                    count++;
                    freqArr[j] = -1;                }
            }

            if (freqArr[i] !=-1) {
                freqArr[i] = count;
            }
        }

        for (int i = 0; i< arr.length; i++){
            System.out.println(freqArr[i]);
        }

    }

    private static void copyOneArrayToOther() {
        int[] arr = new int[]{1, 2,3, 4, 5, 6};
        int[] newArr = new int[arr.length];

        for (int i = 0; i< arr.length; i++){
            newArr[i] = arr[i];
        }

        for (int i = 0; i< arr.length; i++){
            System.out.println(newArr[i]);
        }
    }
}
