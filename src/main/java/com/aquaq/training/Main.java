package com.aquaq.training;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to String Exercise Menu, please select an option:");

        programLoop: while(true) {
            printMenu();
            String answer = scanner.nextLine();
            switch (answer) {
                case "1":
                    question1();break;
                case "2":
                    question2();break;
                case "3":
                    question3();break;
                case "4":
                    question4();break;
                case "5":
                    System.out.println("Exiting game.");break programLoop;
                default:
                    System.out.println("This is not a valid string, please try again");
            }
        }
    }
    public static void question1(){
        String q1String = getAnswer("Enter a string");
        System.out.println("Result: " + MaxCharacter.maxChar(q1String));
    }
    public static void question2(){
        String q2String1 = getAnswer("Enter a string");
        String q2String2 = getAnswer("Enter another string");
        String resultString = Anagram.isAnagram(q2String1, q2String2) ? " are anagrams" : " are not anagrams";
        System.out.println(q2String1 + " and " + q2String2 + resultString);
    }
    public static void question3(){
        String q3String = getAnswer("Enter a string");
        System.out.println("Result: "+Reverse.reverseString(q3String));
    }
    public static void question4(){
        String q4String = getAnswer("Enter a string");
        String answerString = Palindrome.isPalindrome(q4String) ? " is a Palindrome" : " is  not a Palindrome";
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