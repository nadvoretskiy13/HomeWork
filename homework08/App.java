package homework08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
// import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String output = "/Users/dmitriynadvoretskiy/homeworks/HomeWork/homework08/output.txt";
        String input = "/Users/dmitriynadvoretskiy/homeworks/HomeWork/homework08/input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            writer.write("person.addProducts(product)" + "\n");
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Обработка каждой строки
            }
            String[] personsArray = reader.readLine().split(";");
            Person[] people = new Person[personsArray.length];
            for (int i = 0; i < personsArray.length; i++) {
                Person p = new Person(personsArray[i]);
                people[i] = p;
            }
            String[] productArray = reader.readLine().split(";");
            Product[] productss = new Product[productArray.length];
            for (int i = 0; i < productArray.length; i++) {
                Product pp = new Product(productArray[i]);
                productss[i] = pp;
            }
            List<String> purchaseLog = new ArrayList<>();
            while (!line.equalsIgnoreCase("END")) {
                String[] resultss = line.split("-");
                if (resultss.length == 2) {
                    String personName = resultss[0].trim();
                    String productName = resultss[1].trim();
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
            System.out.println();
            for (Person person : people) {
                System.out.println(person);

            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
       }
    }
}