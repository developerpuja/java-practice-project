package com.java.practice.arrays;

public class MaxElementInTheArray {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 100, 50, 56, 76, 900};
        firstMaxElementInTheArray(arr);
        secondMaxElementInTheArray(arr);

    }

    private static void secondMaxElementInTheArray(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int n : arr) {
            if(n > largest) {
                secondLargest = largest;
                largest = n;
            } else if(n> secondLargest && n<largest) {
                secondLargest = n;
            }
        }
        System.out.println(secondLargest);
    }

    private static void firstMaxElementInTheArray(int[] arr) {
        int max = arr[0];
        for (int i = 0; i< arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("Max number:"+ max);
    }
}
