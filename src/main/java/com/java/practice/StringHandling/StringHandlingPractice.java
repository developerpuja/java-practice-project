package com.java.practice.StringHandling;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringHandlingPractice {
    public static void main(String[] args) {
        checkPalindrome();
        findReverseOfString();
       // duplicateCharacterInString();
        //frequencyOfChar();
        //duplicateWordInAString();
        //mostRepeatedWordInString();
        findRepeatingLongestSubString();
    }

    private static void findRepeatingLongestSubString() {
        String str = "acbdfghybdf";
        String longestSubString = "";
        for (int i = 1; i<=str.length(); i++) {
            Set<String> seenSubStrings = new HashSet<>();
            for (int j = 0; j<= str.length()-i; j++) {
                String currentSubString = str.substring(j, j+i) ;
                if (seenSubStrings.contains(currentSubString)) {
                    if (currentSubString.length() > longestSubString.length()){
                        longestSubString = currentSubString;
                    }
                } else {
                    seenSubStrings.add(currentSubString);
                }
            }
        }
        System.out.println("***************"+longestSubString);
    }

    private static void mostRepeatedWordInString() {
        String str = "puja puja puja listen to me study is only the option";
        String[] strings = str.split(" ");
        int[] freq = new int[strings.length];
        for (int i = 0; i< strings.length;  i++) {
            freq[i] = 1;
            for (int j = i+1; j< strings.length; j++) {
                if (strings[i].equals(strings[j])) {
                    freq[i]++;
                    strings[j] = "checked";
                }
            }
        }
    }

    private static void duplicateWordInAString() {
        String s = "hello puja how are you puja";
        String[] strArr = s.split(" ");
        int count;
        for (int i = 0; i< strArr.length; i++) {
            count = 1;
            for (int j = i+1; j < strArr.length; j++) {
                if (strArr[i].equals(strArr[j])) {
                    count++;
                    strArr[j] ="checked";
                }
            }
            if (count > 1 && strArr[i] != "checked") {
                System.out.println("Duplicate word: "+ strArr[i]);
            }
        }
    }

    private static void frequencyOfChar() {
        String str = "puja shingare";
        char[] chars = str.toCharArray();
        int[] freq = new int[chars.length];

        for (int i = 0; i<chars.length ;i++) {
            freq[i] = 1;
            for (int j = i+1; j<chars.length ; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }
        for (int i = 0; i< freq.length; i++) {
            if (chars[i] != ' ' && chars[i] != '0'){
                System.out.println(chars[i] +" - "+ freq[i]);
            }
        }
    }

    private static void duplicateCharacterInString() {
        String str = "puja shingare";
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i<chars.length ; i++) {
            count = 1;
            for (int j = i+1; j<chars.length; j++) {
                if (chars[i] == chars[j] && chars[j] != ' ') {
                    count++;
                    chars[j] = '0';
                }
            }
            if (count > 1 && chars[i] != '0') {
                System.out.println(chars[i]);
            }
        }

        // using Hashmap
        Map<Character, Integer> oc = new HashMap<>();
        for (int j = 0; j<chars.length; j++) {
            if (chars[j] != ' '){
                oc.put(str.charAt(j), oc.getOrDefault(str.charAt(j), 0)+1);
            }
        }
        System.out.println(oc);

        for (Map.Entry<Character, Integer> entry : oc.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() +" "+entry.getValue());
            }
        }
    }

    private static void findReverseOfString() {
        String s = "hello there, how are you";
        String s1 = "";
        StringBuilder sb = new StringBuilder();

        for (int i = s.length()-1; i>= 0 ; i--) {
            s1 +=s.charAt(i);
            sb.append(s.charAt(i));
        }
        System.out.println(s1);
        System.out.println(sb);
    }

    private static void checkPalindrome() {
        String s = "madam";
        StringBuilder rev = new StringBuilder();
        System.out.println(s.length());
        for (int i = s.length()-1;i>=0; i--) {
            rev.append(s.charAt(i));
        }
        if (rev.toString().equals(s)) {
            System.out.println("Given String " +s+ " is a palindrome");
        } else {
            System.out.println("Not a a palindrome");

        }
    }
}
