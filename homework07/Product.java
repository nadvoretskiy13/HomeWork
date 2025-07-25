package homework07;

import java.util.Objects;

public class Product {
    private String name;
    private Double price;

    public Product(String name, double price) {
        this.price = price;
        this.name = name;
    }
    public Product(String paramos) {
        String[]  paramosArray = paramos.split("=");
        this.name = paramosArray[0].trim();
        this.price = Double.valueOf(paramosArray[1].trim());
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Название продукта не может быть пустым");
        }
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Стоимость продукта не может быть отрицательной");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
    @Override
    public String toString() {
        return name;
    }
}
