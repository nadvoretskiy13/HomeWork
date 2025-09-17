package main.java.homeworks.homework11;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("a123me", "Mercedes", "White", 0, 8_300_000),
                new Car("b873of", "Volga", "Black", 0, 673_000),
                new Car("w487mn", "Lexus", "Grey", 76_000, 900_000),
                new Car("p987hj", "Volga", "Red", 610, 704_340),
                new Car("c987ss", "Toyota", "White", 254_000, 761_000),
                new Car("o983op", "Toyota", "Black", 698_000, 740_000),
                new Car("p146op", "BMW", "White", 271_000, 850_000),
                new Car("u893ii", "Toyota", "Purple", 210_900, 440_000),
                new Car("l097df", "Toyota", "Black", 108_000, 780_000),
                new Car("y876wd", "Toyota", "Black", 160_000, 1_000_000)
        );

        String colorToFind = "Black";
        long mileageToFind = 0L;
        long priceFrom = 700_000L;
        long priceTo = 800_000L;
        String modelToFind1 = "Toyota";
        String modelToFind2 = "Volvo";

        // Вывод всех машин
        System.out.println("Автомобили в базе:");
        System.out.println("Number Model Color Mileage Cost");
        cars.forEach(System.out::println);

        // 1) Номера по цвету или пробегу
        String numbers = cars.stream()
                .filter(c -> c.getColor().equalsIgnoreCase(colorToFind) || c.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .collect(Collectors.joining(" "));
        System.out.println("Номера автомобилей по цвету или пробегу: " + numbers);

        // 2) Количество уникальных моделей в диапазоне цены
        long uniqueCount = cars.stream()
                .filter(c -> c.getCost() >= priceFrom && c.getCost() <= priceTo)
                .map(Car::getModel)
                .distinct()
                .count();
        System.out.println("Уникальные автомобили: " + uniqueCount + " шт.");

        // 3) Цвет авто с минимальной ценой
        cars.stream()
                .min(Comparator.comparingLong(Car::getCost))
                .ifPresent(minCar -> System.out.println("Цвет автомобиля с минимальной стоимостью: " + minCar.getColor()));

        // 4) Средняя стоимость по модели
        double avg1 = cars.stream()
                .filter(c -> c.getModel().equalsIgnoreCase(modelToFind1))
                .mapToLong(Car::getCost)
                .average()
                .orElse(0);
        double avg2 = cars.stream()
                .filter(c -> c.getModel().equalsIgnoreCase(modelToFind2))
                .mapToLong(Car::getCost)
                .average()
                .orElse(0);

        System.out.printf("Средняя стоимость модели %s: %,.2f%n", modelToFind1, avg1);
        System.out.printf("Средняя стоимость модели %s: %,.2f%n", modelToFind2, avg2);
    }
}