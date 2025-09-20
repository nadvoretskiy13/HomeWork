package main.java.homeworks.homework16.repository;

import main.java.homeworks.homework16.cars.Car;
import java.util.List;

public interface CarRepository {
    List<Car> findAll();
}

