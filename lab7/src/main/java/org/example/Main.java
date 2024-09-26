package org.example;

import java.util.Arrays;

public class Main {
    static boolean isLatin(String word) {
        return word.matches("[a-zA-Z]+");
    }

    static boolean hasEqualVowelsAndConsonants(String word) {
        String vowelsList = "AEIOUaeiou";

        long vowels = word.chars()
                .filter(c -> vowelsList.indexOf(c) != -1)
                .count();

        long consonants = word.length() - vowels;

        return vowels == consonants;
    }

    public static String[] filterWords(String input) {
        return Arrays.stream(input.split("\\s+"))
                .filter(Main::isLatin)
                .filter(Main::hasEqualVowelsAndConsonants)
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        String input = "test hello aeiou aeibcd deab";
        String[] filteredWords = filterWords(input);

        Arrays.stream(filteredWords).forEach(System.out::println);
    }}