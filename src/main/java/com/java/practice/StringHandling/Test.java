package com.java.practice.StringHandling;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        firstNonRepeatingChar();
        uniqueString();
        findTheUniqueCharacterFromListOfStrings();
    }

    private static void findTheUniqueCharacterFromListOfStrings() {
        List<String> strings = Arrays.asList("AZ","BS", "AW", "CR","BT","EO");
        Set<Character> uniqueStrings = strings.stream().flatMapToInt(String::chars).mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() ==1).map(Map.Entry::getKey).collect(Collectors.toSet());

        System.out.println(uniqueStrings);

    }


    private static void firstNonRepeatingChar() {
        String str="AABBCDDE";
        String s = str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Character::charValue, LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() ==1).map(Map.Entry::getKey).findFirst().toString();
        System.out.println(s);
    }

    private static void uniqueString() {
        List<String> strings = Arrays.asList("A","B", "A", "C","B","E");
        Set<String> duplicateStr = strings.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(stringLongEntry ->stringLongEntry.getValue() >1 ).map(stringLongEntry -> stringLongEntry.getKey()).collect(Collectors.toSet());
        System.out.println(duplicateStr);
    }


}
