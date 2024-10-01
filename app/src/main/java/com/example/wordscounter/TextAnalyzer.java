package com.example.wordscounter;

public class TextAnalyzer {

    //to count words
    public static int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] words = input.trim().split("\\s+");
        return words.length;
    }

    //to count characters
    public static int countCharacters(String input) {
        if (input == null) {
            return 0;
        }
        return input.length();
    }
}
