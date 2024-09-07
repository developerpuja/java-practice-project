package com.java.practice.collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class collections {
    public static void main(String[] args) {
        // mapWorking();
        //hashSetConstructors();
        hashMapAndConcurrentHashMap();
    }

    private static void hashMapAndConcurrentHashMap() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Neha", 1);
        hashMap.put("Puja", 2);

        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(null, 1);
        concurrentHashMap.put("puja", null);

        for (Map.Entry<String, Integer> map : concurrentHashMap.entrySet()) {
            System.out.println(map.getKey() +" "+ map.getValue());
        }
    }

    private static void mapWorking() {
        String s = "Hello there how are you?";
        System.out.println(s.hashCode());

        Map<String, Integer> nameAge = new HashMap<>();
        nameAge.put(null, 0);

        System.out.println(nameAge);

        List<String> names = new ArrayList<>();
        names.add("s1");
        names.add("s2");
        names.add("s3");
        names.add("s4");
        System.out.println(names);
        System.out.println("-------------------------------------------------------------------------");
        Set<String> nameSet = new HashSet<>();
        nameSet.add("s1");
        nameSet.add("s2");
        nameSet.add("s3");
        nameSet.add("s4");
        System.out.println(nameSet);
    }

    static void hashSetConstructors() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>(10);
        Set<String> set3 = new HashSet<>(10, 0.85f);
        Set<String> set4 = new HashSet<>(List.of("H1", "H2", "H2"));
        set2.add("Puja");
        set2.add("Jaya");
        System.out.println(set4);
    }

    static void test() {
        List<String> strings = new LinkedList<>();
        strings.add("Puja1");
        strings.add("Puja2");
        strings.add("Puja3");
        strings.add("Puja4");

        System.out.println(strings.get(1));
    }
}
