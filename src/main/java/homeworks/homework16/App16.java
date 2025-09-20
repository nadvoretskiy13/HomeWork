package main.java.homeworks.homework16;

import homeworks.homework16.cars.Car;
import homeworks.homework16.garage.Garage;
import homeworks.homework16.repository.CarRepository;
import homeworks.homework16.repository.CarRepositoryFileImpl;
import homeworks.homework16.races.CasualRace;
import homeworks.homework16.races.DragRace;
import homeworks.homework16.races.DriftRace;
import homeworks.homework16.races.Race;

import java.util.List;

public class App16 {
    public static void main(String[] args) {
        // Загружаем машины из JSON
        CarRepository repository = new CarRepositoryFileImpl("cars.json");
        List<Car> cars = repository.getAllCars();

        // Создаём гараж и паркуем машины
        Garage garage = new Garage();
        for (Car car : cars) {
            garage.parkCar(car);

            // Тюнинг для примера
            garage.modifyCar(car, 50, 10);
        }

        System.out.println(garage);

        // Гонки
        Race drag = new DragRace(500, "Highway", 10000);
        for (Car car : cars) {
            drag.addParticipant(car);
        }

        Race casual = new CasualRace(300, "City Circuit", 5000);
        for (Car car : cars) {
            casual.addParticipant(car);
        }

        Race drift = new DriftRace(200, "Mountain Drift", 7000);
        for (Car car : cars) {
            drift.addParticipant(car);
        }

        System.out.println("\nDrag Race Winner: " + drag.determineWinner());
        System.out.println("Casual Race Winner: " + casual.determineWinner());
        System.out.println("Drift Race Winner: " + drift.determineWinner());
    }
}

