package homework08;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors; // Важно! Этот импорт нужен для Collectors
import homework08.Product;

public class Person {
    private String name;
    private double money;
    private Product[] products = new Product[0];

    // Конструкторы
    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
    }

    public Person(String params) {
        String[] paramArray = params.split("=");
        this.name = paramArray[0].trim();
        this.money = Double.valueOf(paramArray[1].trim());
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Имя не может быть пустым");
        }
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        } else {
            System.out.println("Деньги не могут быть отрицательными");
        }
    }

    public Product[] getProducts() {
        return products;
    }

    // Метод добавления продукта
    public String addProducts(Product product) {
        if (this.money >= product.getPrice()) {
            products = Arrays.copyOf(products, products.length + 1);
            products[products.length - 1] = product;
            this.money = this.money - product.getPrice();
            return this.name + " купил(а) " + product.getNameProduct();
        }
        return this.name + " не может позволить себе " + product.getNameProduct();
    }

    @Override
    public String toString() {
        if (products.length == 0) {
            return name + " - Ничего не куплено";
        }
        return name + " - " + Arrays.stream(products)
                .map(Product::getNameProduct)
                .collect(Collectors.joining(", ")); // Здесь используется Collectors
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(money, person.money) == 0
                && Objects.equals(name, person.name)
                && Arrays.equals(products, person.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, Arrays.hashCode(products));
    }
}