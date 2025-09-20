package homeworks.homework08;

import java.io.*;
import java.util.*;

public class App08 {
    public static void main(String[] args) {
        String inputFile = "/Users/dmitriynadvoretskiy/homeworks/HomeWork/homeworks.homework01.homework08/input.txt";
        String outputFile = "/Users/dmitriynadvoretskiy/homeworks/HomeWork/homeworks.homework01.homework08/output.txt";

        Map<String, Product> products = new HashMap<>();
        Map<String, Person> people = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            List<String> lines = new ArrayList<>();
            String line;

            // Считываем все строки до END
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.equalsIgnoreCase("END")) break;
                if (!line.isEmpty()) lines.add(line);
            }

            // Обработка первой строки — люди
            if (!lines.isEmpty()) {
                String[] personTokens = lines.get(0).split(";");
                for (String token : personTokens) {
                    String[] parts = token.split("=");
                    if (parts.length == 2) {
                        String name = parts[0].trim();
                        double money = Double.parseDouble(parts[1].trim().replaceAll("[^0-9.]", ""));
                        people.put(name, new Person(name, money));
                    }
                }
            }

            // Обработка второй строки — продукты
            if (lines.size() > 1) {
                String[] productTokens = lines.get(1).split(";");
                for (String token : productTokens) {
                    String[] parts = token.split("=");
                    if (parts.length == 2) {
                        String name = parts[0].trim();
                        double price = Double.parseDouble(parts[1].trim().replaceAll("[^0-9.]", ""));
                        products.put(name, new Product(name, price));
                    }
                }
            }

            for (int i = 2; i < lines.size(); i++) {
                String currentLine = lines.get(i);

                // Поиск имени покупателя
                String matchedPerson = null;
                for (String personName : people.keySet()) {
                    if (currentLine.startsWith(personName + " ")) {
                        matchedPerson = personName;
                        break;
                    }
                }

                // Поиск названия продукта
                String matchedProduct = null;
                for (String productName : products.keySet()) {
                    if (currentLine.endsWith(" " + productName) || currentLine.equals(productName)) {
                        matchedProduct = productName;
                        break;
                    }
                }

                if (matchedPerson != null && matchedProduct != null) {
                    Person person = people.get(matchedPerson);
                    Product product = products.get(matchedProduct);

                    if (person.addProductToBasket(product)) {
                        String verb = matchedPerson.endsWith("на") ? "купила" : "купил";
                        writer.write(String.format("%s %s %s%n", matchedPerson, verb, matchedProduct));
                    } else {
                        writer.write(String.format("%s не может позволить себе %s%n", matchedPerson, matchedProduct));
                    }
                }
            }

            // Итоговая печать корзин
            for (Person person : people.values()) {
                person.printBasketToFile(writer);
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}