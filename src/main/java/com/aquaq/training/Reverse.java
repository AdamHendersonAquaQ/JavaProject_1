package com.aquaq.training;

public class Reverse {
    public static String reverseString(String string)
    {
        String newString = "";
        for(int i=string.length()-1;i>=0;i--) {
            newString = newString.concat(String.valueOf(string.charAt(i)));
        }
        return newString;
    }
}
