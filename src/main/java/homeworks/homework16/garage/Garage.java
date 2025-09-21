package homeworks.homework16.garage;

import homeworks.homework16.cars.Car;
import java.util.List;

public class Garage {

    private List<Car> cars;

    public Garage(List<Car> cars) {
        this.cars = cars;
    }

    // Пример метода сортировки по скорости
    public void sortByTopSpeed() {
        cars.sort((c1, c2) -> Integer.compare(c2.getTopSpeed(), c1.getTopSpeed()));
    }

    public void printCars() {
        cars.forEach(car -> System.out.println(car.getName() + " - " + car.getTopSpeed()));
    }
}
