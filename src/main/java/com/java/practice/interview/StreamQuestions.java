package com.java.practice.interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamQuestions {

    public static void main(String[] args) {
     // maxAppearanceOfString();
     // findPalindrom();
     // frequencyOfCharInString();
        System.out.println(checkTryCatchFinally());

        findElementWithCubeGreaterThan50();
    }

    private static void findElementWithCubeGreaterThan50() {
        List<Integer> integers = List.of(2, 4, 6, 8, 9);
        List<Integer> integers1 = integers.stream().filter(num -> num*num*num > 50).toList();
        System.out.println(integers1);
    }

    private static String checkTryCatchFinally() {
        try {
            int a = 1 % 0;
            return "TRY";
        } catch (Exception e) {
            return "CATCH";
        } finally {
            return "FINALLY";
        }
    }

    private static void frequencyOfCharInString() {
        String s = "Hello Puja, hi please help";
        String s1 =  s.toLowerCase().replaceAll("\\s+", "").replaceAll(",", "");
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        System.out.println(map);
    }

    private static void findPalindrom() {
        String s1 = "madam";
        StringBuilder rev = new StringBuilder();
        for (int i = s1.length()-1; i>=0 ; i--) {
            rev.append(s1.charAt(i));
        }
        if (s1.equals(rev.toString())){
            System.out.println(rev);
        }
    }

    private static void maxAppearanceOfString() {
        List<String> strings = List.of("pen", "pen", "pencil", "pen", "pencil");
        Map.Entry <String, Long> map =  strings.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
        System.out.println(map);
    }

    void test() {
        Integer i = 10;
    }
}
