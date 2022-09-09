package com.aquaq.training;

public class Palindrome {
    public static boolean isPalindrome(String string){
        String cleanString = Shared.cleanString(string);
        return cleanString.equals(Reverse.reverseString(cleanString));
    }
}
