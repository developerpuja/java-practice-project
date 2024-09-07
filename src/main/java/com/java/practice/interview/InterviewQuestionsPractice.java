package com.java.practice.interview;

public class InterviewQuestionsPractice {
    public static void main(String[] args) {
        checkTryCatch();
    }

    private static void checkTryCatch() {
        try {
            throw new NullPointerException();

        } catch (Exception e) {
            //System.exit(0);
            System.out.println("Exception occurred");
        } finally {
            System.out.println("NullPointerException");
        }
    }
}
