
package homework08;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double balance;
    private List<Product> purchasedProducts;

    public Person(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.purchasedProducts = new ArrayList<>();
    }

    public String addProduct(Product product) {
        if (balance >= product.getPrice()) {
            balance -= product.getPrice();
            purchasedProducts.add(product);
            return name + " купил " + product.getName();
        } else {
            return name + " не может позволить себе " + product.getName();
        }
    }

    public String getSummary() {
        if (purchasedProducts.isEmpty()) {
            return name + " - Ничего не куплено";
        }

        StringBuilder sb = new StringBuilder(name + " - ");
        for (int i = 0; i < purchasedProducts.size(); i++) {
            sb.append(purchasedProducts.get(i).getName());
            if (i < purchasedProducts.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }
}