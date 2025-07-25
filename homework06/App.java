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
                    }
                }
                break;
            }
        }
            System.out.println(Arrays.toString(persons).replace("[", "").replace("]", ""));
        }
    }
/*
Павел Андреевич=10000.0; Анна Петровна=2000.0; Борис=10.0
Хлеб=40.0; Молоко=60.0; Торт=1000.0; Кофе Растворимый=879.0; Масло=150.0
Павел Андреевич-Хлеб
Павел Андреевич-Масло
Анна Петровна-Кофе растворимый
Анна Петровна-Молоко
Анна Петровна-Молоко
Анна Петровна-Молоко
Анна Петровна-Торт
Борис-Торт
Павел Андреевич-Торт
*/
