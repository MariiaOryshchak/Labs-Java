package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testIsLatin() {
        assertTrue(Main.isLatin("hello"));  // Тільки латинські символи
        assertFalse(Main.isLatin("привіт")); // Українські символи
        assertFalse(Main.isLatin("1234"));   // Числа
        assertFalse(Main.isLatin("hello123")); // Комбінація літер і цифр
    }

    @Test
    void testHasEqualVowelsAndConsonants() {
        assertFalse(Main.hasEqualVowelsAndConsonants("hello"));  // 2 голосних, 2 приголосних
        assertTrue(Main.hasEqualVowelsAndConsonants("aeibcd")); // 3 голосних, 3 приголосних
        assertFalse(Main.hasEqualVowelsAndConsonants("world")); // 1 голосна, 4 приголосних
        assertFalse(Main.hasEqualVowelsAndConsonants("aeiou")); // Тільки голосні
    }

    @Test
    void testFilterWords() {
        String input = "test hello aeiou aeibcd deab";
        String[] expected = {"aeibcd", "deab"};
        String[] actual = Main.filterWords(input);

        assertArrayEquals(expected, actual); // Перевірка масиву результатів
    }

    @Test
    void testFilterWordsWithNonLatin() {
        String input = "hello привіт test";
        String[] expected = {};
        String[] actual = Main.filterWords(input);

        assertArrayEquals(expected, actual); // Тільки латинські слова
    }

    @Test
    void testEmptyInput() {
        String input = "";
        String[] expected = {};
        String[] actual = Main.filterWords(input);

        assertArrayEquals(expected, actual); // Порожній рядок повинен повертати порожній масив
    }
}