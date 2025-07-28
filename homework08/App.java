package homework08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            // Открываем файл для чтения
            reader = new BufferedReader(new FileReader("/Users/dmitriynadvoretskiy/homeworks/HomeWork/homework08/input.txt"));
            // Открываем файл для записи
            writer = new BufferedWriter(new FileWriter("/Users/dmitriynadvoretskiy/homeworks/HomeWork/homework08/output.txt"));

            System.out.println("Чтение данных о покупателях...");
            String personsLine = reader.readLine();
            String[] personsArray = personsLine.split(";");
            Person[] people = new Person[personsArray.length];

            for (int i = 0; i < personsArray.length; i++) {
                Person p = new Person(personsArray[i]);
                people[i] = p;
            }

            System.out.println("Чтение данных о продуктах...");
            String productsLine = reader.readLine();
            String[] productArray = productsLine.split(";");
            Product[] productss = new Product[productArray.length];

            for (int i = 0; i < productArray.length; i++) {
                Product pp = new Product(productArray[i]);
                productss[i] = pp;
            }

            List<String> purchaseLog = new ArrayList<>();
            System.out.println("Чтение покупок...");

            String line;
            while ((line = reader.readLine()) != null && !line.equalsIgnoreCase("END")) {
                String[] input = line.split("-");
                if (input.length == 2) {
                    String personName = input[0].trim();
                    String productName = input[1].trim();

                    for (Person person : people) {
                        if (person.getName().equals(personName)) {
                            for (Product product : productss) {
                                if (product.getNameProduct().equals(productName)) {
                                    String resultMessage = person.addProducts(product);
                                    purchaseLog.add(resultMessage);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }

            // Записываем результаты в output.txt
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
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка при закрытии файлов: " + e.getMessage());
            }
        }
    }
}