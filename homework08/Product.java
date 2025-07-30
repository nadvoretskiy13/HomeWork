package homework08;

import java.util.Objects;

public class Product {
private String nameProduct;
    private double price;

    // Конструктор с параметрами
    public Product(String nameProduct, double price) {
        this.nameProduct = nameProduct;
        this.price = price;
    }

    // Исправленный конструктор для чтения из файла
    public Product(String params) {
        String[] paramArray = params.split("=");
        if (paramArray.length != 2) {
            throw new IllegalArgumentException("Неверный формат данных");
        }
        this.nameProduct = paramArray[0].trim();
        this.price = Double.valueOf(paramArray[1].trim());
    }

    // Геттер для названия продукта
    public String getNameProduct() {
        return nameProduct;
    }

    // Сеттер для названия продукта
    public void setNameProduct(String nameProduct) {
        if (!nameProduct.isEmpty()) {
            this.nameProduct = nameProduct;
        } else {
            System.out.println("Название продукта не может быть пустым");
        }
    }

    // Геттер для цены
    public double getPrice() {
        return price;
    }

    // Сеттер для цены
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Стоимость продукта не может быть отрицательной");
        }
    }

    @Override
    public String toString() {
        return nameProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0
                && Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, price);
    }
}
