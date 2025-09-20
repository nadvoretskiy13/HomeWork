package homeworks.homework16;

import homeworks.homework16.cars.Car;
import homeworks.homework16.garage.Garage;
import homeworks.homework16.repository.CarRepository;
import homeworks.homework16.repository.CarRepositoryFileImpl;

import java.util.List;

public class App16 {
    public static void main(String[] args) {
        CarRepository repository = new CarRepositoryFileImpl("cars.json");
        List<Car> cars = repository.getAllCars();

        Garage garage = new Garage();
        for (Car car : cars) {
            garage.parkCar(car);
        }
    }
}
