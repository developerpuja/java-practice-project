package com.java.practice.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice2 {
    public static void main(String[] args) {
        getTheSumOfAllListNumber();
        groupByLenthandGetCount();
        flattenTheLists();
        sortedUniques();
        convertInUpperCase();
        productOfAllNumbers();
        partionEvenAndOdd();
        customCollect();
    }

    private static void customCollect() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        String s = words.stream().collect(Collectors.joining(","));
        System.out.println(s);
    }

    private static void partionEvenAndOdd() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
      Map<Boolean, List<Integer>> partition =  numbers.stream().collect(Collectors.partitioningBy(n -> n%2 ==0));
        System.out.println(partition);
    }

    private static void productOfAllNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
       Integer num = numbers.stream().reduce(1, (a, b) -> a*b);
        System.out.println(num);
    }

    private static void convertInUpperCase() {
        List<String> names = Arrays.asList("alice", "bob", "charlie");
        List<String> upperCase  = names.stream().map(String::toUpperCase).toList();
        System.out.println(upperCase);
    }

    private static void sortedUniques() {
        List<Integer> numbers = Arrays.asList(3, 1, 2, 4, 2, 3, 5, 1);
        List<Integer> sortedNumbers = numbers.stream().sorted().distinct().toList();
        System.out.println(sortedNumbers);
    }

    private static void flattenTheLists() {
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        Integer numbers = listOfLists.stream().flatMap(List::stream).max(Comparator.comparingInt(Integer::intValue)).orElse(null);
        System.out.println(numbers);
    }

    private static void groupByLenthandGetCount() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
       Map<Integer, Long> map = names.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(map);
    }

    private static void getTheSumOfAllListNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer sum = numbers.stream().collect(Collectors.summingInt(value -> value.intValue()));
        Integer sum1 = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        System.out.println(sum1);
    }
}
