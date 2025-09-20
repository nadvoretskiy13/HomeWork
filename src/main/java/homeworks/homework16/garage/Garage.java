package homeworks.homework16.garage;

import homeworks.homework16.cars.Car;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
public class Garage {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void showCarsSortedByTopSpeed() {
        cars.stream()
                .sorted(Comparator.comparingInt(Car::getTopSpeed).reversed())
                .forEach(c -> System.out.println(c.getMake() + " " + c.getModel() + " - " + c.getTopSpeed() + " km/h"));
    }

    public void showCarsSortedByHorsepower() {
        cars.stream()
                .sorted(Comparator.comparingInt(Car::getHorsepower).reversed())
                .forEach(c -> System.out.println(c.getMake() + " " + c.getModel() + " - " + c.getHorsepower() + " hp"));
    }
}
