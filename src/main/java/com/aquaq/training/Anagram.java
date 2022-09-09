package com.aquaq.training;

import java.util.Arrays;

public class Anagram {
    public static boolean isAnagram(String string1, String string2){
        String sortedString1 = getSortedLetters(string1);
        String sortedString2 = getSortedLetters(string2);
        return sortedString1.equals(sortedString2);
    }
    public static String getSortedLetters(String string){
        String cleanString = Shared.cleanString(string);
        char[] charArray = cleanString.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
