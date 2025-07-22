package homework06;

import java.util.Arrays;
import java.util.Objects;

public class Person {
    private String name;

    private Double money;

    private  Product[] products = new Product[0];


    public Person(String name, Double money) {
        this.setName(name);
        this.setMoney(money);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        if (money >= 0) {
            this.money = money;
        }
    }

    public Product[] getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (this.money >= product.getPrice()) {
            products = Arrays.copyOf(products, products.length + 1);
            products[products.length - 1] = product;
            this.money = this.money - product.getPrice();
        } else {
            System.out.println(this.name + " Не может себе позволить купить " + product.getName());

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(money, person.money) && Objects.deepEquals(products, person.products);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, money, Arrays.hashCode(products));

    }

    @Override
    public String toString() {
        if (products.length == 0) {
            return name + " ничего не купил! ";
        } else {
            return name + " купил: " + Arrays.toString(products) + " - осталось денег " + this.money;
        }
    }
}
