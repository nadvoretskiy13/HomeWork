package homework07;
import homework06.Person;
import homework06.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        DiscountProduct cake = new DiscountProduct("Торт", 800.15, 19.985, true);
        DiscountProduct Coffee = new DiscountProduct("Кофе растворимый", 432.5, 50.8, true);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные о покупателях: ");
        String[] personsArray = scanner.nextLine().split(";");
        homework06.Person[] people = new homework06.Person[personsArray.length];
        for (int i = 0; i < personsArray.length; i++) {
            homework06.Person p = new homework06.Person(personsArray[i]);
            people[i] = p;
        }
        System.out.println("Введите данные о продуктах: ");
        String[] productArray = scanner.nextLine().split(";");
        homework06.Product[] productss = new homework06.Product[productArray.length];
        for (int i = 0; i < productArray.length; i++) {
            homework06.Product pp = new homework06.Product(productArray[i]);
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
                for (homework06.Person person : people) {
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