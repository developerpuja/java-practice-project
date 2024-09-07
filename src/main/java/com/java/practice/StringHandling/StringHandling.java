package com.java.practice.StringHandling;


public class StringHandling {
    public static void main(String[] args) {
        String s = "hello there how are you and how are your children";
       // duplicateWordsInString(s);
        //duplicatesFromTheString(s);
       // reverseTheGivenString(s);
       // findIfTwoStringsAnagram();
        System.out.println(findIfTwoStringsAnagram1());
        //System.out.println(palindromUsingPointer());
    }

    private static String findIfTwoStringsAnagram1() {
        String s1 = "listen";
        String s2 = "silent";
        int count = 0;
        if (s1.length() != s2.length())
            return "Not a anagram";
        for (int i = 0; i< s1.length(); i++) {
            for (int j = 0; j<s1.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)){
                    count++;
                }
            }

            if(count != 1) {
                return "Not a anagram";
            }
        }
        return "Anagram";
    }

    private static boolean palindromUsingPointer() {
        String s = "madam";

        int left = 0;
        int right = s.length()-1;
        while (left<right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

    private static void findIfTwoStringsAnagram() {
        String s1 = "listen";
        String s2 = "silent";
        char[] arr1 = s1.toCharArray();// convert s1 to char array
        char[] arr2 = s2.toCharArray();// convert s2 to char array

        for (int i = 0; i< arr1.length ; i++) {
            for (int j = i+1; j< arr1.length; j++) {
                // sort both the array
                if (arr1[i]>arr1[j]) {
                    char temp1 = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp1;
                }
                if (arr2[i] > arr2[j]){
                    char temp2 = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp2;
                }
            }
        }
        System.out.println(new String(arr1));
        System.out.println(new String(arr2));
        // convert the array to String and compare
        if (new String(arr1).equals(new String(arr2))) {
            System.out.println("It a Anagram");
        }
    }

    private static void duplicateWordsInString(String s) {
        String[] strArray = s.split(" ");

        for (int i = 0; i< strArray.length; i++) {
            int count = 1;
            for (int j = i+1; j< strArray.length; j++) {
                if (strArray[i].equals( strArray[j])) {
                    count++;
                    strArray[j]= "checked";
                }
            }

            if (count >1 && !strArray[i].equals("checked")) {
                System.out.println("Duplicate word "+ strArray[i]);
            }
        }
    }

    private static void duplicatesFromTheString(String s) {
        char[] charArray = s.replaceAll("\\s+", "").toCharArray();
        int count;
        for (int i = 0; i<charArray.length; i++) {
            count = 1;
            for (int j = i+1; j<charArray.length;j++ ){
                if (charArray[i] == charArray[j] && s.charAt(j) != ' ') {
                    count++;
                    charArray[j] = '0';
                }
            }

            if (count > 1 && charArray[i] != '0')
                System.out.println("Duplicate: " + charArray[i]);
        }
    }

    private static void reverseTheGivenString(String s) {
        // char[] charArr = s.toCharArray();
        String revString = "";
        for (int i = s.length()-1; i>=0; i--) {
            revString = revString + s.charAt(i);
        }
        System.out.println(revString);
    }
}
