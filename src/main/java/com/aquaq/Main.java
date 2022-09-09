package com.aquaq;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to String Exercise Menu, please select an option:");

        programLoop: while(true) {
            System.out.println("\nProblem Menu:");
            System.out.println("1: Find the max occurring char in String");
            System.out.println("2: Check 2 String are anagrams of each other");
            System.out.println("3: Reverse entered String");
            System.out.println("4: Check if String is a palindrome");
            System.out.println("5: Exit");
            String answer = scanner.nextLine();

            switch (answer) {
                case "1":
                    System.out.println("Enter a string");
                    String string1 = scanner.nextLine();
                    System.out.println("Result: " + maxChar(string1));
                    break;
                case "2":
                    System.out.println("Enter a string");
                    String string2 = scanner.nextLine();
                    System.out.println("Enter another string");
                    String string2_ = scanner.nextLine();
                    String resultString = isAnagram(string2, string2_) ? " are anagrams" : " are not anagrams";
                    System.out.println(string2 + " and " + string2_ + resultString);
                    break;
                case "3":
                    System.out.println("Enter a string");
                    String string3 = scanner.nextLine();
                    System.out.println("Result: "+reverseString(string3));
                    break;
                case "4":
                    System.out.println("Enter a string");
                    String string4 = scanner.nextLine();
                    String answerString = isPalindrome(string4) ? " is a Palindrome" : " is  not a Palindrome";
                    System.out.println(string4+ answerString);
                    break;
                case "5":
                    System.out.println("Exiting game.");
                    break programLoop;
                default:
                    System.out.println("This is not a valid string, please try again");
            }
        }
    }
    public static String reverseString(String string)
    {
        String newString = "";
        for(int i=string.length()-1;i>=0;i--)
        {
            newString+=string.charAt(i);
        }
        return newString;
    }
    public static boolean isPalindrome(String string){
        String clearString = string.toLowerCase().replaceAll("[^a-zA-Z]", "");

        return clearString.equals(reverseString(clearString));
    }
    public static boolean isAnagram(String string1, String string2){
        String clearString1 = string1.toLowerCase().replaceAll("[^a-zA-Z]","");
        char[] charArray = clearString1.toCharArray();
        Arrays.sort(charArray);
        String sortedString1 = new String(charArray);

        String clearString2 = string2.toLowerCase().replaceAll("[^a-zA-Z]","");
        charArray = clearString2.toCharArray();
        Arrays.sort(charArray);
        String sortedString2 = new String(charArray);

        return sortedString1.equals(sortedString2);
    }
    public static char maxChar(String string)
    {
        int maxNum = 0;
        char maxChar=' ';
        for(int i =0; i<string.length();i++)
        {
            char newChar = string.toLowerCase().charAt(i);
            if(newChar != ' ' && newChar != maxChar) {
                int tempCount =0;
                for(int k =0; k<string.length();k++) {
                    if(string.toLowerCase().charAt(k) == string.toLowerCase().charAt(i)) {tempCount++;}
                }
                if(tempCount>maxNum){
                    maxNum=tempCount;
                    maxChar=string.toLowerCase().charAt(i);}
            }
        }
        return maxChar;
    }
}