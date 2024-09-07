package com.java.practice.com.dp.demo;

public class StringHandling {
    public static void main(String[] args) {
        System.out.println(printReverseString("Hello there how are you"));
    }

    private static String printReverseString(String s) {
        char[] chars = s.toCharArray();

        String str = "";
        for (int i = chars.length-1 ; i>=0; i--) {
            str = str+chars[i];
        }

        return str;
    }
}
