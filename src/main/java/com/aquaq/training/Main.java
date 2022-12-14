package com.aquaq.training;

import java.util.Scanner;

public class Main {
    public static StringEvaluation stringEvaluation = new StringEvaluation();
    public static final String defaultQuestionString = "Enter a string";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to String Exercise Menu, please select an option:");
        programLoop: do {
            printMenu();
            String answer = scanner.nextLine();
            switch (answer) {
                case "1":
                    question1(getAnswer(scanner, defaultQuestionString));break;
                case "2":
                    question2(getAnswer(scanner, defaultQuestionString),
                            getAnswer(scanner, "Enter another string"));break;
                case "3":
                    question3(getAnswer(scanner, defaultQuestionString));break;
                case "4":
                    question4(getAnswer(scanner, defaultQuestionString));break;
                case "5":
                    System.out.println("Exiting game.");break programLoop;
                default:
                    System.out.println("This is not a valid option, please try again");
            }
        } while(true);
    }
    public static void question1(String q1String){
        System.out.println("Result: " + stringEvaluation.maxChar(q1String));
    }
    public static void question2(String q2String1, String q2String2){
        String resultString = stringEvaluation.isAnagram(q2String1, q2String2) ? " are anagrams" : " are not anagrams";
        System.out.println(q2String1 + " and " + q2String2 + resultString);
    }
    public static void question3(String q3String){
        System.out.println("Result: "+stringEvaluation.reverseString(q3String));
    }
    public static void question4(String q4String){
        String answerString = stringEvaluation.isPalindrome(q4String) ? " is a Palindrome" : " is not a Palindrome";
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
    public static String getAnswer(Scanner scanner, String question)
    {
        System.out.println(question);
        return scanner.nextLine();
    }
}