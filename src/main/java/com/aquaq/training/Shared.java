package com.aquaq.training;

public class Shared {
    public static String cleanString(String string)
    {
        return string.toLowerCase().replaceAll("[^a-zA-Z]","");
    }
}
