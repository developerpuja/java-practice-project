package com.java.practice.StringHandling;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.*;
import java.util.stream.Collectors;

//Problem-solving with String handling
public class StringHandlingPart1 {
    
    public static void main(String[] args) {
//        printEvenLengthStrings();
//        insertNewStringAtGivenIndex();
//        swapPairOfCharacter();
//        replaceSpecificIndexChar();
//        removeLeadingZero();
//        sortAString("software");
//        findAllPossibleSubStringOfAString("puja");
          findAllFirstConsecutiveRepeatingChars("aabbccddeffgghhii");
//        findAllPossiblePalindromicSubStrings("abab");
//        findLongestSubStringWithoutRepeatingChar("abacb");
        findLongestPossiblePalindromicSubStrings("abaaba");
//        longestPalindromeSubsequence("bbbab");
//        findOneStringInAnotherString();
     //   System.out.println(isValid("aabbcd"));

    }

    public static String isValid(String s) {

        Map<Integer, Long> map = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Character::charValue, Collectors.counting())).values().stream().collect(Collectors.groupingBy(Long::intValue, Collectors.counting()));
        System.out.println(map);
        if(map.size() == 1) {
            return "YES";
        }

        if (map.size() == 2) {
            int freq1= 0;int freq2= 0;
            long count1 = 0;long count2 = 0;

            for(Map.Entry<Integer, Long> entry: map.entrySet()){
                if(freq1 == 0){
                    freq1 = entry.getKey();
                    count1 = entry.getValue();
                } else {
                    freq2 = entry.getKey();
                    count2 = entry.getValue();
                }
            }

            if((count1 == 1 && (freq1 ==1 || freq1-1 == freq2)) || (count2 == 1 &&(freq2-1 == freq1))) {
                return "YES";
            }
        }
        return "YES";

    }

    private static void findOneStringInAnotherString() {
        String A = "bc";
        String B = "abcddbc";
        int n = A.length();
        int m = B.length();

        for (int i = 0; i< m-n; i++) {

            int j;
            for(j = 0; j<m; j++){

            }

        }

    }

    private static void longestPalindromeSubsequence(String s) {
        Set<String> set = new HashSet<>();
        for(int i=0; i< s.length() ; i++) {
            String seq = "";
            for(int j=i+1; j< s.length() ; j++) {
                seq +=s.charAt(i);
                //System.out.println(seq);
                StringBuilder sb = new StringBuilder(seq);
                if(sb.reverse().toString().equals(seq)){
                    set.add(seq);
                }
            }
        }

        System.out.println(set);

        String s1 = set.stream().max(Comparator.comparingInt(String::length)).orElse("");
        System.out.println(s1.length());
    }

    private static void findLongestPossiblePalindromicSubStrings(String str) {
        Set<String> set = new HashSet<>();
        String longestSubString = "";
        for (int i = 0; i < str.length(); i++){
            for (int j = i+1; j<= str.length() ;j++) {
                String subString = str.substring(i , j);
                StringBuilder sb = new StringBuilder(subString);
                if (sb.toString().equals(sb.reverse().toString())){
                    if(subString.length() > longestSubString.length()) {
                        longestSubString = subString;
                    }
                    set.add(subString);
                }
            }
        }

        String s = set.stream().max(Comparator.comparingInt(String::length)).orElse(null);
        System.out.println(s);
        System.out.println(longestSubString);
    }

    // get the array of unique characters
    private static void findLongestSubStringWithoutRepeatingChar(String str) {
        char[] charArr =  str.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i< str.length(); i++) {
            set.add(charArr[i]);
        }
        for (int i = 0; i< set.size(); i++) {
            for (int j = i+1; j<= set.size(); j++) {
               // String s =
            }
        }
        System.out.println(set);
    }

    private static void findAllPossiblePalindromicSubStrings(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i< str.length(); i++) {
            for (int j = i+1; j<= str.length(); j++) {
                StringBuilder subString = new StringBuilder(str.substring(i, j));

                if (subString.toString().equals(subString.reverse().toString())) {
                    list.add(subString.toString());
                }
            }
        }
        System.out.println("Size: "+list.size());
    }

    private static void findAllFirstConsecutiveRepeatingChars(String str) {
        if (str == null || str.length()<2) {
            return;
        }
        Set<Character> set = new LinkedHashSet<>();

        for (int i = 0; i<str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                set.add(str.charAt(i));
            }
        }
        System.out.println(set);
    }

    private static void findAllPossibleSubStringOfAString(String str) {
        // hashset to avoid duplicates
        Set<String> set = new LinkedHashSet<>();
        //two iteration start to end
        for (int start = 0; start<str.length(); start++) {
            for (int end = start+1; end<=str.length() ; end++){
                String subString = str.substring(start, end);
                set.add(subString);
            }
        }
        System.out.println(set);
    }

    private static void sortAString(String software) {
        char[] arr = software.toCharArray();
        for (int i = 0; i< arr.length-1; i++) {
            for (int j = i+1; j< arr.length; j++) {
                if (arr[i] > arr[j]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        }

        System.out.println(new String(arr));
    }

    private static void removeLeadingZero() {
        String str = "000012356098";
        String newStr = "";
        int i = 0;

        while (str.charAt(i) == '0')
            i++;

        for (int j = i; j < str.length(); j++) {
            newStr+=str.charAt(j);
        }
        System.out.println(newStr);
    }

    private static void replaceSpecificIndexChar() {
        String str = "Geeks for geeks";
        char[] arr = str.toCharArray();
        int index = 10 ;
        char ch = 'G';
        int count = 0;
        for (int i = 0; i< arr.length; i++) {
            //System.out.println(count++);
            if(i == index){
                arr[i] = ch;
                break;
            }
        }
        System.out.println(new String(arr));
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(index, ch);

        System.out.println(sb);
    }

    private static void swapPairOfCharacter() {
        String str = "GeeksForGeeks";
        char[] arr = str.toCharArray();

        for (int i =0;i< arr.length-1; i+=2) {
            char temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
        System.out.println(new String(arr));
    }

    private static void insertNewStringAtGivenIndex() {
        String s = "GeeksGeeks";
        String is = "ISFor";
        int index = 4;
        String newString = "";
        for (int i = 0; i< s.length()-1; i++) {
            if (i == index+1) {
                newString+=is;
            }
            newString += s.charAt(i);
        }
        System.out.println(newString);
    }

    private static void printEvenLengthStrings() {
        String s = "This is a java language are you there";
        String[] sArr = s.split(" ");
        for (int i = 0; i< sArr.length; i++) {
            if (sArr[i].length()%2==0) {
                System.out.println(sArr[i]);
            }
        }
    }
}
