package homeworks.homework16.garage;

import homeworks.homework16.cars.Car;
import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Car> cars = new ArrayList<>();

    public void park(Car car) {
        cars.add(car);
    }

    public int getTotalHorsepower() {
        return cars.stream().mapToInt(Car::getHorsepower).sum();
    }
}

