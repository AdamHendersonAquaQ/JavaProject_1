package com.aquaq.training;

public class StringEvaluation {
        public boolean isAnagram(String string1, String string2){
            String sortedString1 = getSortedLetters(string1);
            String sortedString2 = getSortedLetters(string2);
            return sortedString1.equals(sortedString2);
        }
        public String getSortedLetters(String string){
            String cleanString = cleanString(string);
            char[] charArray = cleanString.toCharArray();
            for(int i = 0; i < charArray.length;i++) {
                for(int j = i+1; j<charArray.length;j++) {
                    if(charArray[i]>charArray[j]) {
                        char temp = charArray[j];
                        charArray[j]=charArray[i];
                        charArray[i]=temp;
                    }
                }
            }
            return new String(charArray);
        }

    public char maxChar(String string)
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
    public int countChar(String string, char newChar)
    {
        int counter = 0;
        for(int k =0; k<string.length();k++) {
            if(string.toLowerCase().charAt(k) == newChar) {counter++;}
        }
        return counter;
    }

    public boolean isPalindrome(String string){
        String cleanString = cleanString(string);
        for(int i =0;i<=(cleanString.length()-1)/2;i++) {
            if(cleanString.charAt(i)!=cleanString.charAt(cleanString.length()-1-i))
                return false;
        }
        return true;
    }

    public String reverseString(String string)
    {
        String newString = "";
        for(int i=string.length()-1;i>=0;i--) {
            newString = newString.concat(String.valueOf(string.charAt(i)));
        }
        return newString;
    }

    public String cleanString(String string)
    {
        return string.toLowerCase().replaceAll("[^a-zA-Z]","");
    }
}
