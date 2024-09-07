package com.java.practice.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamQuestions1 {
    public static void main(String[] args) {
        getMaxAppearedElement();
        findFreqOfLettersInString();
    }

    private static void findFreqOfLettersInString() { // find later which is repeated more than once
        String s1 = "Hello puja, how are you";
        String s2 = s1.replaceAll("\\s+", "").replaceAll(",", "").toLowerCase();

        for (int i = 0; i <= s2.length(); i++) {
            int visited = 0;
            int count = 1;
            for (int j = i+1; j <= s2.length()-1 ; j++) {
                if (s2.charAt(i) == s2.charAt(j)) {
                    count++;
                    visited = 1;
                }
            }

            if (count > 1 && visited != 0) {
                System.out.println("Duplicate element "+ s2.charAt(i)+", occurred "+count+" times" );
            }
        }

        // using map
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        System.out.println(map);
    }

    private static void getMaxAppearedElement() {
        List<String> items = List.of("pen", "pen", "pencil", "pen", "pencil");
        Map.Entry<String, Long> map = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);

        System.out.println(map);
    }
}
