package homeworks.homework16;

import homeworks.homework16.cars.Car;
import homeworks.homework16.garage.Garage;
import homeworks.homework16.repository.CarRepository;
import homeworks.homework16.repository.CarRepositoryFileImpl;

import java.util.List;

public class App16 {
    public static void main(String[] args) {
        CarRepository repo = new CarRepositoryFileImpl("cars.txt");

        List<Car> cars = repo.getAllCars();

        Garage garage = new Garage(cars);

        System.out.println("Before sorting by top speed:");
        garage.printCars();

        garage.sortByTopSpeed();

        System.out.println("\nAfter sorting by top speed:");
        garage.printCars();
    }
}
