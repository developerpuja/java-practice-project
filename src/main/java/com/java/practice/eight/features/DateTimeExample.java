package com.java.practice.eight.features;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeExample {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime  localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localTime);
        System.out.println(localDate);
    }
}
