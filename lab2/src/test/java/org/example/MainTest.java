package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testInputWithValidationCorrectInput() {
        String input = "Petro";
        String pattern = "[\\p{L}’`'-]+";
        assertTrue(input.matches(pattern));
    }

    @Test
    void testInputWithValidationIncorrectInput() {
        String input = "Petro123";
        String pattern = "[\\p{L}’`'-]+";
        assertFalse(input.matches(pattern));
    }

    @Test
    void testInputBirthDateValid() {
        LocalDate expectedDate = LocalDate.of(2000, 5, 15);
        String inputDate = "2000-05-15";

        LocalDate actualDate = LocalDate.parse(inputDate, Main.dateFormatter);
        assertEquals(expectedDate, actualDate);
    }

    @Test
    void testInputBirthDateInvalid() {
        String invalidDate = "15-05-2000";  // Невірний формат дати
        assertThrows(Exception.class, () -> {
            LocalDate.parse(invalidDate, Main.dateFormatter);
        });
    }
}