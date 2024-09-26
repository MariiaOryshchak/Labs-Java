package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testIsLatin() {
        assertTrue(Main.isLatin("test"));
        assertTrue(Main.isLatin("hello"));
        assertFalse(Main.isLatin("тест")); // слово кирилицею
        assertFalse(Main.isLatin("123test")); // слово містить цифри
        assertFalse(Main.isLatin("test!")); // слово містить спеціальні символи
    }

    // Тест на метод, що перевіряє рівну кількість голосних і приголосних
    @Test
    void testHasEqualVowelsAndConsonants() {
        assertTrue(Main.hasEqualVowelsAndConsonants("baba")); // 2 голосні, 2 приголосні
        assertTrue(Main.hasEqualVowelsAndConsonants("aadd")); // 2 голосні, 2 приголосні
        assertFalse(Main.hasEqualVowelsAndConsonants("hello")); // не рівна кількість
        assertFalse(Main.hasEqualVowelsAndConsonants("aiei")); // 4 голосні, 0 приголосних
        assertFalse(Main.hasEqualVowelsAndConsonants("bcd")); // 0 голосних
    }

    // Тест на основний метод, який фільтрує слова
    @Test
    void testFilterWords() {
        String input = "hello baba aeibcd test ABCD aeIoU aeIoX";
        String[] expected = {"baba", "aeibcd"};
        String[] result = Main.filterWords(input);
        assertArrayEquals(expected, result); // Перевіряємо, що результат відповідає очікуваному масиву
    }

    // Тест для рядка з не-латинськими символами
    @Test
    void testFilterWordsWithNonLatin() {
        String input = "Привіт test aeIoU 123abc !@# baba";
        String[] expected = {"baba"};
        String[] result = Main.filterWords(input);
        assertArrayEquals(expected, result);
    }

    // Тест для порожнього рядка
    @Test
    void testFilterWordsWithEmptyInput() {
        String input = "";
        String[] expected = {};
        String[] result = Main.filterWords(input);
        assertArrayEquals(expected, result);
    }

    // Тест для рядка без слів, що відповідають умовам
    @Test
    void testFilterWordsWithNoValidWords() {
        String input = "123 Привіт !@#";
        String[] expected = {};
        String[] result = Main.filterWords(input);
        assertArrayEquals(expected, result);
    }
}