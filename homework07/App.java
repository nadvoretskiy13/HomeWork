package homework07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные о покупателях: ");
        String[] personsArray = scanner.nextLine().split(";");
        DiscountProduct[] discount = new DiscountProduct[][discountArray.length];
        for (int i = 0; i < personsArray.length; i++) {
            DiscountProduct p = new DiscountProduct(discountArray[i]);
            discounts[i] = p;
        }

        System.out.println("Введите данные о продуктах: ");

        String[] productArray = scanner.nextLine().split(";");
        Product[] productss = new Product[productArray.length];
        for (int i = 0; i < productArray.length; i++) {
            Product pp = new Product(productArray[i]);
            productss[i] = pp;
        }

        List<String> purchaseLog = new ArrayList<>();
    }
}