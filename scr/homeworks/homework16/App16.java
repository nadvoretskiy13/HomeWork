package homeworks.homework16;

import homeworks.homework16.cars.Car;
import homeworks.homework16.repository.CarRepository;
import homeworks.homework16.repository.CarRepositoryFileImpl;

import java.util.List;

public class App16 {
    public static void main(String[] args) {
        CarRepository repo = new CarRepositoryFileImpl("cars.json");
        List<Car> cars = repo.findAll();

        cars.forEach(System.out::println);
    }
}
