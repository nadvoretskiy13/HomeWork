package homework08;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        String inputFile = "/Users/dmitriynadvoretskiy/homeworks/HomeWork/homework08/input.txt";  // Используем относительный путь
        String outputFile = "/Users/dmitriynadvoretskiy/homeworks/HomeWork/homework08/output.txt";

        Map<String, Product> products = new HashMap<>();
        Map<String, Person> people = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {

            List<String> lines = new ArrayList<>();
            String line;

            // Читаем все строки файла
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }

            // Парсим покупателей и продукты
            boolean readingProducts = false;
            boolean processingPurchases = false;

            for (String currentLine : lines) {
                if (currentLine.equalsIgnoreCase("END")) break;

                if (currentLine.contains("=")) {
                    String[] parts = currentLine.split("=");
                    String name = parts[0].trim();
                    String valueStr = parts[1].trim();

                    // Очищаем строку от лишних символов для парсинга числа
                    valueStr = valueStr.replaceAll("[^0-9.]", "");
                    double value = Double.parseDouble(valueStr);

                    // Определяем тип записи
                    if (isProductName(name)) {
                        readingProducts = true;
                        products.put(name, new Product(name, value));
                    } else {
                        people.put(name, new Person(name, value));
                    }
                }

                // Обрабатываем покупки
                if (!currentLine.contains("=") && !people.isEmpty() && !products.isEmpty()) {
                    processingPurchases = true;
                }

                if (processingPurchases) {
                    String[] purchase = currentLine.split(" ");
                    if (purchase.length == 2) {
                        String personName = purchase[0];
                        String productName = purchase[1];

                        Person person = people.get(personName);
                        Product product = products.get(productName);

                        if (person != null && product != null) {
                            if (person.addProductToBasket(product)) {
                                String verb = personName.endsWith("на") ? "купила" : "купил";
                                bufferedWriter.write(String.format("%s %s %s%n", personName, verb, productName));
                            } else {
                                bufferedWriter.write(String.format("%s не может позволить себе %s%n", personName, productName));
                            }
                        }
                    }
                }
            }

            // Выводим итоговые корзины
            for (Person person : people.values()) {
                person.printBasketToFile(bufferedWriter);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isProductName(String name) {
        return name.equals("Хлеб") || name.equals("Молоко") || name.equals("Торт") ||
                name.equals("Кофе растворимый") || name.equals("Масло");
    }
}