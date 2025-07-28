package homework08;


public class Product {
    // Приватные поля класса
    private String name;    // название продукта
    private double price;   // цена продукта

    // Конструктор класса
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Геттер для получения названия
    public String getName() {
        return name;
    }

    // Геттер для получения цены
    public double getPrice() {
        return price;
    }

    // Метод для сравнения объектов Product
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Double.compare(price, product.price) == 0 &&
                name.equals(product.name);
    }

    // Метод для получения хэш-кода
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Double.hashCode(price);
        return result;
    }

    // Метод для получения строкового представления
    @Override
    public String toString() {
        return name + " (" + price + " руб.)";
    }
}