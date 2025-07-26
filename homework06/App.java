package homework06;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные о людях: ");
        String[] personStringArray = scanner.nextLine().split(";");
        Person[] persons = new Person[personStringArray.length];

        for (int i = 0; i < personStringArray.length; i++) {
            Person p = new Person(personStringArray[i]);
            persons[i] = p;
        }
        System.out.println("Введите данные о продуктах: ");
        String[] productStringArray = scanner.nextLine().split(";");
        Product[] products = new Product[productStringArray.length];
        for (int i = 0; i < productStringArray.length; i++) {
            Product r = new Product(productStringArray[i]);
            products[i] = r;
        }
        System.out.println("\n--- Начинаем покупки ---");
        String line = scanner.nextLine();
        while (!line.equalsIgnoreCase("END")) {
            String[] input = line.split("-");
            if (input.length == 2) {
                String personName = input[0].trim();
                String productName = input[1].trim();

                for (Person person : persons) {
                    if (person.getName().equals(personName)) {
                        for (Product product : products) {
                            if (product.getName().equals(productName)) {
                                person.addProduct(product);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            line = scanner.nextLine();
        }
            System.out.println("\n");
            System.out.println(Arrays.toString(persons).replace("[", "").replace("]", ""));
        }
    }

