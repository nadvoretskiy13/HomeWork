package main.java.homeworks.homework14;

import java.util.Objects;

public class Product {
    private String nameProduct;
    private double price;

    public Product(String nameProduct, double price) {
        this.setNameProduct(nameProduct);
        this.setPrice(price);
    }

    public Product(String params) {
        String[] paramsArray = params.split("=");
        if (paramsArray.length != 2) {
            throw new IllegalArgumentException("Неверный формат строки для создания Product. Используйте 'Товар=Цена'");
        }
        this.setNameProduct(paramsArray[0].trim());
        this.setPrice(Double.parseDouble(paramsArray[1].trim()));
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        if (nameProduct == null || nameProduct.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Стоимость продукта не может быть отрицательной");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return nameProduct + " (" + price + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 &&
                Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, price);
    }
}
