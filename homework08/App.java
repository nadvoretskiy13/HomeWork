package homework08;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/dmitriynadvoretskiy/homeworks/HomeWork/homework08/input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/dmitriynadvoretskiy/homeworks/HomeWork/homework08/output.txt"))) {

            // Читаем покупателей
            String personsLine = reader.readLine();
            String[] personsArray = personsLine.split(";");
            List<Person> people = new ArrayList<>();

            for (String personData : personsArray) {
                String[] parts = personData.split("=");
                people.add(new Person(parts[0].trim(), Double.parseDouble(parts[1].trim())));
            }

            // Читаем продукты
            String productsLine = reader.readLine();
            String[] productArray = productsLine.split(";");
            List<Product> products = new ArrayList<>();

            for (String productData : productArray) {
                String[] parts = productData.split("=");
                products.add(new Product(parts[0].trim(), Double.parseDouble(parts[1].trim())));
            }

            // Создаем мапы для быстрого поиска
            Map<String, Person> personMap = new HashMap<>();
            for (Person person : people) {
                personMap.put(person.getName(), person);
            }

            Map<String, Product> productMap = new HashMap<>();
            for (Product product : products) {
                productMap.put(product.getName(), product);
            }

            // Обрабатываем покупки
            List<String> purchaseLog = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null && !line.equalsIgnoreCase("END")) {
                String[] input = line.split(" ");
                if (input.length == 2) {
                    String personName = input[0].trim();
                    String productName = input[1].trim();

                    Person person = personMap.get(personName);
                    Product product = productMap.get(productName);

                    if (person != null && product != null) {
                        String result = person.addProduct(product);
                        purchaseLog.add(result);
                        writer.write(result + "\n");
                    }
                }
            }

            // Добавляем пустую строку
            writer.newLine();

            // Записываем итоговые списки покупок
            for (Person person : people) {
                writer.write(person.getSummary() + "\n");
            }

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}