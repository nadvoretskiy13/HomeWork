package main.java.homeworks.homework07;

import java.util.Objects;

public class Product {
    private String nameProduct;
    private double price;

    public Product(String nameProduct, double price) {
        this.nameProduct = nameProduct;
        this.price = price;
    }
    public Product(String paramss) {
        String[] paramssArray = paramss.split("=");
        this.nameProduct = paramssArray[0].trim();
        this.price = Double.valueOf(paramssArray[1].trim());
    }
    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        if (!nameProduct.isEmpty()) {
            this.nameProduct = nameProduct;
        }
        if (nameProduct.length() <= 3) {
            System.out.println("Недопустимое имя продукта!");
        } else {
            System.out.println("Название продукта не может быть пустым");
        }
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, price);
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
        if (price == 0) {
            System.out.println("Недопустимая стоимость продукта");
        } else {
            System.out.println("Стоимость продукта не может быть отрицательной");
        }
    }
}