package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class JournalEntryTest {
    @Test
    void testJournalEntryCreation() {
        LocalDate birthDate = LocalDate.of(2000, 5, 15);
        JournalEntry entry = new JournalEntry("Ivanenko", "Petro",
                birthDate, "0981234567", "Shevchenka, 10, apt. 5");

        assertEquals("Ivanenko", entry.getLastName());
        assertEquals("Petro", entry.getFirstName());
        assertEquals(birthDate, entry.getBirthDate());
        assertEquals("0981234567", entry.getPhoneNumber());
        assertEquals("Shevchenka, 10, apt. 5", entry.getAddress());
    }

    @Test
    void testToStringMethod() {
        LocalDate birthDate = LocalDate.of(2000, 5, 15);
        JournalEntry entry = new JournalEntry("Ivanenko", "Petro",
                birthDate, "0981234567", "Shevchenka, 10, apt. 5");

        String expectedString = "Студент: Ivanenko Petro\n" +
                "Дата народження: 2000-05-15\n" +
                "Телефон: 0981234567\n" +
                "Адреса: Shevchenka, 10, apt. 5";

        assertEquals(expectedString, entry.toString());
    }
}