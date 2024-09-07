package com.java.practice.StringHandling.substrings;

import java.util.*;
import java.util.stream.Collectors;

public class SubStrings {
    public static void main(String[] args) {
        String mainString = "hello world";
        String subString = "world";
      //  findIfOneStringIsSubStringOfAnother(mainString, subString);
     //       totalNoOfPalindromicSubStrings();
    //       getAllTheSubStringsWithoutRepeatingChars();
   //    lengthOfALongestSubStringWithoutRepeatingChars();
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramIdx = new ArrayList<>();
        for(int i = 0; i<=s.length()-p.length(); i++) {
           // for(int j = i+1; j<=s.length(); j++) {
                String subString = s.substring(i, i+p.length());
                String sorted = getSortedString(subString);
                if(sorted.equals(p)) {
                    anagramIdx.add(i);
                }
           // }
        }
        return anagramIdx;
    }

    private static String getSortedString(String subString){
        return subString.chars().mapToObj(c -> (char)c).sorted().map(String::valueOf).collect(Collectors.joining());
    }

    private static void lengthOfALongestSubStringWithoutRepeatingChars() {
        String str = "abcabcbb";
        char[] arr = str.toCharArray();
        Set<Character> set = new HashSet<>();
        int i =0, j=0, max = 0;
        System.out.println("LENGTH:-"+ str.length());
        System.out.println("Arr:-"+ arr.length);
        while (i<str.length()) {
            System.out.println("i: "+i+"str.length: "+ str.length());
            if(!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
               // max = Math.max(max, set.size());
                i++;
                System.out.println("IF: "+set);
            } else {
                set.remove(str.charAt(j));
                System.out.println("ELSE: "+set);
                j++;
            }
        }
        System.out.println(set.size());
    }

    private static void getAllTheSubStringsWithoutRepeatingChars() {
        String s = "abac";
        String strWithUniqueChar = getUniqueCharString(s);
        System.out.println(strWithUniqueChar);
        List<String> list = new ArrayList<>();
        for (int i = 0; i< strWithUniqueChar.length(); i++) {
            for (int j = i+1; j<= strWithUniqueChar.length(); j++){
                list.add(strWithUniqueChar.substring(i, j));
            }
        }

        String longestS = list.stream().max(Comparator.comparingInt(String::length)).orElse("bbbbb");
        System.out.println(longestS);
        System.out.println(list);
    }

    private static String getUniqueCharString(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i<s.length(); i++) {
           set.add(s.charAt(i));
        }
        String s1 = "";

        for (Character character : set){
            s1+=character;
        }
        return s1;
    }

    private static void totalNoOfPalindromicSubStrings() {
        String s = "bb";
        List<String> palinStrings = new ArrayList<>();
        for (int i = 0; i< s.length(); i++) {
            for (int j = i+1; j<=s.length(); j++) {
                String subString = s.substring(i, j);
                System.out.println(subString);
                StringBuilder sb = new StringBuilder(subString);
                System.out.println(sb.reverse().toString().equals(subString));
                if (sb.reverse().toString().equals(subString)){
                    palinStrings.add(subString);
                }
            }
        }
        System.out.println(palinStrings+"--"+palinStrings.size());
    }

    /*
        1. dont forget validations
        2. validate length of s2 , it should be greater that n the s1.
        3. only one for loop as you are checking s2 is substring of s1, no need to get all the substrings,
         only get substrings with length of s2
        4. once you get that s2 is substring of s1 break the loop.
     */
    private static void findIfOneStringIsSubStringOfAnother(String mainString, String subString) {
        int mainLength = mainString.length();
        int subLength = subString.length();
        String result = "";

        if(subLength>mainLength)
            result= "Not a SubString";

        for (int i = 0; i<= mainLength-1; i++) {
            String ns = mainString.substring(i, i+subLength);
            if(ns.equals(subString)){
                result = "SubString";
                break;
            }

        }
        System.out.println(result);

    }
}
