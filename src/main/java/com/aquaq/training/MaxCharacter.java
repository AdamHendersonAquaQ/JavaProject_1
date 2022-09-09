package com.aquaq.training;

public class MaxCharacter {
    public static char maxChar(String string)
    {
        int maxNum = 0;
        char maxChar=' ';
        for(int i =0; i<string.length();i++)
        {
            char newChar = string.toLowerCase().charAt(i);
            if(newChar != ' ' && newChar != maxChar) {
                int counter = countChar(string,newChar);
                if(counter>maxNum){
                    maxNum=counter;
                    maxChar=newChar;}
            }
            string=string.replaceAll(String.valueOf(newChar)," ");
        }
        return maxChar;
    }
    public static int countChar(String string, char newChar)
    {
        int counter = 0;
        for(int k =0; k<string.length();k++) {
            if(string.toLowerCase().charAt(k) == newChar) {counter++;}
        }
        return counter;
    }
}
