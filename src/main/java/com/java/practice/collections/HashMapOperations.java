package com.java.practice.collections;


import java.util.HashMap;
import java.util.Map;

public class HashMapOperations {
    public static void main(String[] args) {
        Map<String, Integer> nameAge = new HashMap<>();
        nameAge.put(null, null);
        nameAge.put("Puja", 20);
        nameAge.put("Jaya", 30);
        nameAge.put("Maya", 21);
        nameAge.put("Sona", 20);

        for (Map.Entry<String, Integer> entry : nameAge.entrySet()){
            System.out.println(entry.getKey());
            nameAge.put("Riya", 4);
        }

        System.out.println(nameAge);
    }
}
