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
            Person[] people = new Person[personsArray.length];
            for (int i = 0; i < personsArray.length; i++) {
                Person p = new Person(personsArray[i]);
                people[i] = p;
            }

            // Читаем продукты
            String productsLine = reader.readLine();
            String[] productArray = productsLine.split(";");
            Product[] products = new Product[productArray.length];
            for (int i = 0; i < productArray.length; i++) {
                Product pp = new Product(productArray[i]);
                products[i] = pp;
            }

            List<String> purchaseLog = new ArrayList<>();

            // Читаем покупки
            String line = reader.readLine();
            while (!line.equalsIgnoreCase("END")) {
                String[] input = line.split("-");
                if (input.length == 2) {
                    String personName = input[0].trim();
                    String productName = input[1].trim();

                    for (Person person : people) {
                        if (person.getName().equals(personName)) {
                            for (Product product : products) {
                                if (product.getNameProduct().equals(productName)) {
                                    String resultMessage = person.addProducts(product);
                                    purchaseLog.add(resultMessage);
                                    writer.write(resultMessage + "\n");
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
                line = reader.readLine();
            }

            // Записываем итоговые списки покупок
            writer.newLine();
            for (Person person : people) {
                writer.write(person.toString() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}