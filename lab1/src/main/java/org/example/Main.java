package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean isLatin(String word) {
        return word.matches("[a-zA-Z]+");
    }

    static boolean hasEqualVowelsAndConsonants(String word) {
        int vowels = 0, consonants = 0;
        String vowelsList = "AEIOUaeiou";

        for (char c : word.toCharArray()) {
            if (vowelsList.indexOf(c) != -1) {
                vowels++;
            } else {
                consonants++;
            }
        }

        return vowels == consonants;
    }

    public static String[] filterWords(String input) {
        String[] words = input.split("\\s+"); // розбиваємо рядок на слова
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (isLatin(word) && hasEqualVowelsAndConsonants(word)) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String input = "test hello aeiou aeibcd deab";
        String[] filteredWords = filterWords(input);

        for (String word : filteredWords) {
            System.out.println(word);
        }
    }
}
