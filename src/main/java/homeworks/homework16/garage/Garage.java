package homeworks.homework16.garage;

import homeworks.homework16.cars.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
public class Garage {
    private List<Car> cars;

    public void printCars() {
        cars.forEach(System.out::println);
    }

    public void sortByTopSpeed() {
        cars.sort(Comparator.comparingInt(Car::getTopSpeed).reversed());
    }

    public Car mostPowerful() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getHorsepower))
                .orElse(null);
    }
}
