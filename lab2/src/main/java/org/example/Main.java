package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<JournalEntry> journalEntries = new ArrayList<>();
    static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Додати запис");
            System.out.println("2. Відобразити всі записи");
            System.out.println("3. Вийти");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addEntry();
                    break;
                case "2":
                    displayEntries();
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    static void addEntry() {
        System.out.println("Введіть інформацію про студента:");

        String lastName = inputWithValidation("Прізвище: ", "[\\p{L}’`'-]+",
                "Прізвище повинно містити лише літери.");

        String firstName = inputWithValidation("Ім'я: ", "[\\p{L}’`'-]+",
                "Ім'я повинно містити лише літери.");

        LocalDate birthDate = inputBirthDate();
        String phoneNumber = inputWithValidation("Телефон: ", "\\d{10}",
                "Телефон повинен містити 10 цифр.");

        String address = inputWithValidation("Адреса (вулиця, будинок, квартира): ",
                ".+", "Адреса не може бути порожньою.");

        // Додаємо новий запис до журналу
        journalEntries.add(new JournalEntry(lastName, firstName, birthDate, phoneNumber, address));

        System.out.println("Запис успішно додано!");
    }

    // Метод для введення та валідації даних
    private static String inputWithValidation(String prompt, String pattern, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (Pattern.matches(pattern, input)) {
                return input;
            } else {
                System.out.println(errorMessage);
            }
        }
    }

    // Метод для введення та валідації дати народження
    private static LocalDate inputBirthDate() {
        while (true) {
            System.out.print("Дата народження (yyyy-MM-dd): ");
            String dateInput = scanner.nextLine();
            try {
                return LocalDate.parse(dateInput, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Невірний формат дати. Спробуйте ще раз.");
            }
        }
    }

    // Метод для відображення всіх записів
    private static void displayEntries() {
        if (journalEntries.isEmpty()) {
            System.out.println("Записи відсутні.");
        } else {
            System.out.println("Записи у журналі куратора:");
            for (JournalEntry entry : journalEntries) {
                System.out.println(entry);
                System.out.println("-------------------------");
            }
        }
    }
}