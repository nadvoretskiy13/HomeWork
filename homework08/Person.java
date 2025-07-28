package homework08;

import java.util.ArrayList;
import java.util.List;

public class Person {
    // Приватные поля класса
    private String name;          // имя покупателя
    private double balance;       // баланс покупателя
    private List<Product> purchasedProducts;  // список купленных товаров

    // Конструктор класса
    public Person(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.purchasedProducts = new ArrayList<>();
    }

    // Геттер для получения имени
    public String getName() {
        return name;
    }

    // Геттер для получения баланса
    public double getBalance() {
        return balance;
    }

    // Сеттер для установки баланса
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Метод добавления продукта
    public String addProduct(Product product) {
        if (balance >= product.getPrice()) {
            balance -= product.getPrice();  // уменьшаем баланс
            purchasedProducts.add(product); // добавляем продукт в список
            return getName() + " купил " + product.getName();
        } else {
            return getName() + " не может позволить себе " + product.getName();
        }
    }

    // Метод для получения строкового представления объекта
    @Override
    public String toString() {
        if (purchasedProducts.isEmpty()) {
            return getName() + " - Ничего не куплено";
        }

        StringBuilder sb = new StringBuilder(getName() + " - ");
        for (int i = 0; i < purchasedProducts.size(); i++) {
            sb.append(purchasedProducts.get(i).getName());
            if (i < purchasedProducts.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    // Метод для сравнения объектов Person
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Double.compare(balance, person.balance) == 0 &&
                name.equals(person.name);
    }

    // Метод для получения хэш-кода
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Double.hashCode(balance);
        return result;
    }
}
