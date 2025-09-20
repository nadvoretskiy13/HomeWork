package main.java.homeworks.homework12;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (Фамилия Имя Отчество, дата рождения, номер телефона, пол возраст):");

        String input = scanner.nextLine();
        String[] parts = input.split("\\s+");

        try {
            if (parts.length != 7) {
                throw new IllegalArgumentException("Неверное количество полей: требуется 7, а получено " + parts.length);
            }

            String lastName = parts[0];
            String firstName = parts[1];
            String middleName = parts[2];

            LocalDate birthDate;
            try {
                birthDate = LocalDate.parse(parts[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Неверный формат даты рождения. Ожидается dd.MM.yyyy");
            }

            long phoneNumber;
            try {
                phoneNumber = Long.parseLong(parts[4]);
                if (phoneNumber < 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Неверный формат номера телефона. Ожидается целое беззнаковое число");
            }

            char gender = parts[5].toLowerCase().charAt(0);
            if (gender != 'm' && gender != 'f') {
                throw new IllegalArgumentException("Пол должен быть указан символом 'm' или 'f'");
            }

            int age;
            try {
                age = Integer.parseInt(parts[6]);
                if (age < 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Возраст должен быть положительным целым числом");
            }

            Person person = new Person(lastName, firstName, middleName, birthDate, phoneNumber, gender, age);
            writeToFile(person);

            System.out.println("Данные успешно записаны: " + person);

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом:");
            e.printStackTrace();
        }
    }

    private static void writeToFile(Person person) throws IOException {
        String fileName = person.getLastName() + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(person.toString() + System.lineSeparator());
        }
    }
}
