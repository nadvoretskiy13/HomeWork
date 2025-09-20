package homeworks.homework16.cars;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private String model;
    private int year;
    private double price;

    // Конструктор без аргументов для Jackson
    public Car() {
    }

    // Конструктор с аргументами
    @JsonCreator
    public Car(@JsonProperty("model") String model,
               @JsonProperty("year") int year,
               @JsonProperty("price") double price) {
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // Геттеры и сеттеры
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}


