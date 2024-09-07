package com.java.practice.StringHandling.reversestring;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReverseString {
    public static void main(String[] args) {
        String str = "helloworld";
        String s = "i love programming very much";
        reverseString1(str);
        reverseString2(str);
        reverseString3(str);
        reverseWordsInGivenString1(s);
        reverseWordsInGivenString2(s);
        reverseAStringWithoutUsingThirdVariable(str);
    }

    private static void reverseAStringWithoutUsingThirdVariable(String str) {

    }

    private static void reverseWordsInGivenString2(String s) {
       String revStr = s.chars().mapToObj(c->(char)c).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
            Collections.reverse(list);
            return list.stream();
        })).map(String::valueOf).collect(Collectors.joining());

        String revStr1 =  Arrays.stream(s.split("")).reduce("", (a, b)->b+a, (c,d)-> c+d);
        System.out.println(revStr);
        System.out.println(revStr1);
    }

    private static void reverseWordsInGivenString1(String s) {
        String[] strArr = s.split(" ");
        String s1 = "";
        for (int i = strArr.length-1; i>=0; i--) {
            s1+=strArr[i]+" ";
        }
        System.out.println(s1.trim());
    }

    private static void reverseString3(String str) {
        String revStr = str.chars().mapToObj(c->(char)c).reduce("", (a, b) -> b+a, (c,d) -> d+c);
        System.out.println(revStr);
    }

    private static void reverseString2(String str) {
        char[] arr = str.toCharArray();
        int left = 0;
        char temp;
        int right = str.length()-1;
        while (left < right) {
             temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            right--;
            left++;
        }

        System.out.println(new String(arr));
    }

    private static void reverseString1(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length()-1; i>=0; i--){
            sb.append(str.charAt(i));
        }

        System.out.println(sb);
    }
}
