package homeworks.homework14;

import homeworks.homework06.Person;
import homeworks.homework06.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные о покупателях: ");
        String[] personsArray = scanner.nextLine().split(";");
        Person[] people = new Person[personsArray.length];
        for (int i = 0; i < personsArray.length; i++) {
            Person p = new Person(personsArray[i]);
            people[i] = p;
        }
        System.out.println("Введите данные о продуктах: ");
        String[] productArray = scanner.nextLine().split(";");
        Product[] productss = new Product[productArray.length];
        for (int i = 0; i < productArray.length; i++) {
            Product pp = new Product(productArray[i]);
            productss[i] = pp;
        }
        List<String> purchaseLog = new ArrayList<>();
        System.out.println("Введите имя покупателя и товар");
        String line = scanner.nextLine();
        while (!line.equalsIgnoreCase("END")) {
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
            line = scanner.nextLine();
        }
        for (String message : purchaseLog) {
            System.out.println(message);
        }
        System.out.println();
        for (Person person : people) {
            System.out.println(person);
        }
    }
}

/* Павел Андреевич = 10000; Анна Петровна = 2000; Борис = 10
Хлеб = 40; Молоко = 60; Торт = 1000; Кофе растворимый = 879; Масло = 150
Павел Андреевич - Хлеб
Павел Андреевич - Масло
Анна Петровна Кофе - растворимый
Анна Петровна - Молоко
Анна Петровна - Молоко
Анна Петровна - Молоко
Борис - Торт
END */