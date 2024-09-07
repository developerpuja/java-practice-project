package com.java.practice.Exception.handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandlingSuper {

    ExceptionHandlingSuper(String s) {
        System.out.println(s);
    }

    void checkExcpHadling(Integer num) throws ArithmeticException {
        int i = num % 0;
        System.out.println(i);

    }

    void checkCheckedException() throws IOException {
        FileReader  file = new FileReader("C:\\test\\a.txt");
        // Creating object as one of ways of taking input
        BufferedReader fileInput = new BufferedReader(file);

        // Printing first 3 lines of file "C:\test\a.txt"
        for (int counter = 0; counter < 3; counter++)
            System.out.println(fileInput.readLine());

        // Closing file connections
        // using close() method
        fileInput.close();
    }

    void testMethod() {
        System.out.println("No exception thrown here");
    }


}
