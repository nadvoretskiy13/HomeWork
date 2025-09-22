package homeworks.homework16;

import homeworks.homework16.cars.Car;
import homeworks.homework16.garage.Garage;
import homeworks.homework16.races.CasualRace;
import homeworks.homework16.races.DragRace;
import homeworks.homework16.races.DriftRace;
import homeworks.homework16.repository.CarRepository;
import homeworks.homework16.repository.CarRepositoryFileImpl;

import java.nio.file.Paths;
import java.util.List;

public class App16 {
    public static void main(String[] args) {
        CarRepository repo = new CarRepositoryFileImpl(Paths.get("src/main/resources/cars.txt"));
        List<Car> cars = repo.getAllCars();

        Garage garage = new Garage(cars);
        System.out.println("🚗 Машины в гараже:");
        garage.printCars();

        garage.sortByTopSpeed();
        System.out.println("\n🚀 Отсортированные по скорости:");
        garage.printCars();

        System.out.println("\n💪 Самая мощная машина: " + garage.mostPowerful());

        System.out.println("\n🏁 DragRace победитель: " + new DragRace(cars).start());
        System.out.println("🏁 DriftRace победитель: " + new DriftRace(cars).start());
        System.out.println("🏁 CasualRace победитель: " + new CasualRace(cars).start());
    }
}
