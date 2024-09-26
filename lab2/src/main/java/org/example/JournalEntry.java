package org.example;

import java.time.LocalDate;

public class JournalEntry {
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String phoneNumber;
    private String address;

    public JournalEntry(String lastName, String firstName, LocalDate birthDate, String phoneNumber, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Студент: " + lastName + " " + firstName + "\nДата народження: " + birthDate + "\n" +
                "Телефон: " + phoneNumber + "\nАдреса: " + address;
    }
}
