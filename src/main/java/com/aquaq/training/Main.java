package com.aquaq.training;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to String Exercise Menu, please select an option:");
        programLoop: do {
            printMenu();
            String answer = scanner.nextLine();
            switch (answer) {
                case "1":
                    question1(getAnswer("Enter a string"));break;
                case "2":
                    question2(getAnswer("Enter a string"),
                            getAnswer("Enter another string"));break;
                case "3":
                    question3(getAnswer("Enter a string"));break;
                case "4":
                    question4(getAnswer("Enter a string"));break;
                case "5":
                    System.out.println("Exiting game.");break programLoop;
                default:
                    System.out.println("This is not a valid option, please try again");
            }
        } while(true);
    }
    public static void question1(String q1String){
        System.out.println("Result: " + StringEvaluation.maxChar(q1String));
    }
    public static void question2(String q2String1, String q2String2){
        String resultString = StringEvaluation.isAnagram(q2String1, q2String2) ? " are anagrams" : " are not anagrams";
        System.out.println(q2String1 + " and " + q2String2 + resultString);
    }
    public static void question3(String q3String){
        System.out.println("Result: "+StringEvaluation.reverseString(q3String));
    }
    public static void question4(String q4String){
        String answerString = StringEvaluation.isPalindrome(q4String) ? " is a Palindrome" : " is not a Palindrome";
        System.out.println(q4String + answerString);
    }
    public static void printMenu()
    {
        System.out.println("\nProblem Menu:");
        System.out.println("1: Find the max occurring char in String");
        System.out.println("2: Check 2 String are anagrams of each other");
        System.out.println("3: Reverse entered String");
        System.out.println("4: Check if String is a palindrome");
        System.out.println("5: Exit");
    }
    public static String getAnswer(String question)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.nextLine();
    }
}