package homework06;

import java.util.Arrays;
import java.util.Objects;

public class Person {
    private String name;
    private Long money;
    private final Product[] products = new Product[10];
    public Person(String name, Long money, Product[] products) {
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
    public Long getMoney() {
        return money;
    }
    public void setMoney(Long money) {
        if (money >= 0) {
            this.money = money;
        }
    }
    public Product[] getProducts() {
        return products;
    }
    public void addProduct(Product products) {
    }
    @Override
    public String toString() {
        return "Person{" +
                "Имя='" + name + '\'' +
                ", Деньги=" + money +
                ", Продукты=" + Arrays.toString(products) +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(money, person.money) && Objects.deepEquals(products, person.products);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, money, Arrays.hashCode(products));
    }
}
