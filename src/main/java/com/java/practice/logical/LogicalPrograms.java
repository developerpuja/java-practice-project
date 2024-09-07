package com.java.practice.logical;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LogicalPrograms {
    /**
     * No in built methods should be used here
     * @param args
     */
    public static void main(String[] args) {
        String word = "hello java";
        reverseStringApproachOne(word);
        reverseStringApproachTwo(word);
        reverseStringApproachThree(word);
        swapTwoNumbersApproachOne();
        swapTwoNumbersApproachTwo();
        swapTwoNumbersApproachThree();
        countNumberOfWordsInAStringUsingHashMap();
        iterateHashMapUsingWhile();
        findIfGivenNumIsPrime();
    }

    private static void findIfGivenNumIsPrime() {
        int num = 5;

    }

    private static void iterateHashMapUsingWhile() {
        Map<String, Integer> words1 = new HashMap<>();
        words1.put("hello", 1);
        words1.put("sona", 7);
        words1.put("mona", 0);
        words1.put("rup", 3);
        words1.put("puja", 4);
        Iterator<Map.Entry<String, Integer> > iterator = words1.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() +"-"+entry.getValue());

        }
    }

    private static void countNumberOfWordsInAStringUsingHashMap() {
        String sentence = "hello puja how are you puja you Are great";
        String[] strArr = sentence.split(" ");
        Map<String, Long> words = Arrays.stream(strArr).map(String::toLowerCase).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(words);
        Map<String, Integer> words1 = new HashMap<>();
        for (String s : strArr) {
            words1.put(s, words1.getOrDefault(s, 0)+1);
        }
        System.out.println(words1);
    }

    private static void swapTwoNumbersApproachThree() {
        int a = 10; int b = 20;
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a +", "+ b);
    }

    private static void swapTwoNumbersApproachTwo() {
        int a = 10; int b = 20;
        a = a*b;
        b = a/b;
        a = a/b;
        System.out.println(a +", "+ b);
    }

    private static void swapTwoNumbersApproachOne() {
        int a = 10; int b = 20;
         a = a+b;
         b = a-b;
         a = a-b;
        System.out.println(a +", "+ b);
    }

    private static void reverseStringApproachThree(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = word.length()-1; i>=0; i--) {
            stringBuilder.append(word.charAt(i));
        }
        System.out.println(stringBuilder);
    }

    // this approach is not good as on every iteration it will create new string object
    private static void reverseStringApproachTwo(String word) {
        String rev = "";
        for (int i = word.length()-1 ; i>= 0; i--){
           rev+=word.charAt(i);
            System.out.println(System.identityHashCode(rev));
        }
        System.out.println(rev);
    }

    private static void reverseStringApproachOne(String word) {
        char[] charArr = word.toCharArray();
        int left = 0, right = charArr.length-1;
        while (left < right) {
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;
            left++;
            right--;
        }

        System.out.println(new String(charArr));
    }
}
