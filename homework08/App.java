package homework08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader("/Users/dmitriynadvoretskiy/homeworks/HomeWork/homework08/input.txt"));
            writer = new BufferedWriter(new FileWriter("/Users/dmitriynadvoretskiy/homeworks/HomeWork/homework08/output.txt"));

            // Читаем покупателей
            String personsLine = reader.readLine();
            String[] personsArray = personsLine.split(";");
            List<Person> people = new ArrayList<>();

            for (String personData : personsArray) {
                String[] parts = personData.split("=");
                String name = parts[0].trim();
                double balance = Double.parseDouble(parts[1].trim());
                people.add(new Person(name, balance));
            }

            // Читаем продукты
            String productsLine = reader.readLine();
            String[] productArray = productsLine.split(";");
            List<Product> products = new ArrayList<>();

            for (String productData : productArray) {
                String[] parts = productData.split("=");
                String name = parts[0].trim();
                double price = Double.parseDouble(parts[1].trim());
                products.add(new Product(name, price));
            }

            // Читаем покупки
            List<String> purchaseLog = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null && !line.equalsIgnoreCase("END")) {
                String[] input = line.split(" ");

                if (input.length == 2) {
                    String personName = input[0].trim();
                    String productName = input[1].trim();

                    for (Person person : people) {
                        if (person.getName().equals(personName)) {
                            for (Product product : products) {
                                if (product.getName().equals(productName)) {
                                    String resultMessage = person.addProduct(product);
                                    purchaseLog.add(resultMessage);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }

            // Записываем результаты
            for (String message : purchaseLog) {
                writer.write(message + "\n");
            }
            writer.newLine();

            for (Person person : people) {
                writer.write(person.toString() + "\n");
            }

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.err.println("Ошибка при закрытии файлов: " + e.getMessage());
            }
        }
    }
}