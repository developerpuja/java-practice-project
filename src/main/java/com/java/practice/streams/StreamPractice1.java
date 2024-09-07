package com.java.practice.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice1 {
    public static void main(String[] args) {
        mergeTwoListOfInteger();
        filterGreaterThan10AndGetAvg();
        partitionAListOfNumbersIntoEvenAndOdd();
        uniqueWordsFromListOfSentences();
        flattenListOfInteger();
        ListToMap();
        groupStringsByLength();
        convertListOfStringToListOfIntLength();
        countCharOccurences();
        productOfAllElement();
        firstNonRepeatingCharFromString();
    }

    private static void firstNonRepeatingCharFromString() {
        String s = "pujashingareprepareu";
        Character ch = s.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue() ==1).map(Map.Entry ::getKey).findFirst().orElse(null);
        System.out.println(ch);
    }

    private static void productOfAllElement() {
        List<Integer> numbers1 = List.of(1, 2, 4, 6,8);

        Integer intValue = numbers1.stream().reduce(1, (a, b) -> a*b );
        System.out.println(intValue);
    }

    private static void countCharOccurences() {
        String s = "hellothere";
        Map<Character, Long> map = s.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

    private static void convertListOfStringToListOfIntLength() {
        List<String> words = List.of("Hello","puja", "name");
        List<Integer> ints = words.stream().map(String::length).toList();
        System.out.println(ints);
    }

    private static void groupStringsByLength() {
        List<String> words = List.of("Hello","puja", "name");
        Map<Integer, List<String>> map = words.stream().collect(Collectors.groupingBy(String::length));
        Map<Integer, List<String>> map1 = words.stream().collect(Collectors.groupingBy(str -> str.length()));
        System.out.println(map);
        System.out.println(map1);

    }

    private static void ListToMap() {
        List<String> sentences = List.of("Hello","puja", "name");
        Map<String, Integer> map = sentences.stream().collect(Collectors.toMap(str -> str, String::length));
        System.out.println(map);
    }

    private static void flattenListOfInteger() {
        List<List<Integer>> list = List.of(List.of(1,2, 3, 4), List.of(5, 6, 7, 8));
        List<Integer> list1 = list.stream().flatMap(integers -> integers.stream()).toList();
        List<Integer> list2 = list.stream().flatMap(Collection::stream).toList();
        System.out.println(list1);
        System.out.println(list2);
    }

    private static void uniqueWordsFromListOfSentences() {
        List<String> sentences = List.of("Hello puja", "Hello sona", "my name is puja");
        Set<String> uniqueWords = sentences.stream().flatMap(sentence->Arrays.stream(sentence.split(" "))).map(String::toLowerCase).collect(Collectors.toSet());
        System.out.println(uniqueWords);
    }

    private static void partitionAListOfNumbersIntoEvenAndOdd() {
        List<Integer> numbers1 = List.of(1, 2, 4, 6, 8, 11, 55, 23, 21, 90);
        Map<Boolean, List<Integer>> map = numbers1.stream().collect(Collectors.partitioningBy(n -> n%2 == 0));
        System.out.println(map);
    }

    private static void filterGreaterThan10AndGetAvg() {
        List<Integer> numbers1 = List.of(1, 2, 4, 6, 8, 11, 55, 23, 21, 90);
        Double integer = numbers1.stream().filter(num -> num > 10).collect(Collectors.averagingInt(Integer::intValue));
        OptionalDouble doubleOptional = numbers1.stream().filter(num -> num > 10).mapToDouble(value -> value).average();
        System.out.println(doubleOptional.orElse(0));
        System.out.println(integer);
    }

    private static void mergeTwoListOfInteger() {
        List<Integer> numbers1 = List.of(1, 2, 4, 6,8);
        List<Integer> numbers2 = List.of(1, 7, 5, 6,8);

        Set<Integer> unique = Stream.concat(numbers1.stream(), numbers2.stream()).collect(Collectors.toSet());
        System.out.println(unique);
    }
}
