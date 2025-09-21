package homeworks.homework16.repository;

import homeworks.homework16.cars.Car;
import homeworks.homework16.cars.ShowCar;
import homeworks.homework16.cars.PerformanceCar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryFileImpl implements CarRepository {

    private final String fileName;

    public CarRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                String name = parts[1];
                int horsepower = Integer.parseInt(parts[2]);
                if (type.equals("ShowCar")) {
                    cars.add(new ShowCar(name, horsepower));
                } else if (type.equals("PerformanceCar")) {
                    cars.add(new PerformanceCar(name, horsepower));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }
}

