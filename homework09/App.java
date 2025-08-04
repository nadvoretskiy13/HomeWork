package homework09;

import homework09.cars.Car;
import homework09.cars.PerformanceCar;
import homework09.cars.ShowCar;
import homework09.garage.Garage;
import homework09.races.CasualRace;
import homework09.races.DragRace;
import homework09.races.DriftRace;
import homework09.races.Race;
public class App {
    public static void main(String[] args) {
        // Создание машин
        PerformanceCar bmw = new PerformanceCar("BMW", "M3", 2020, 400, 4, 100, 80);
        ShowCar audi = new ShowCar("Audi", "R8", 2021, 610, 3, 110, 90);
        audi.setStars(2);

        // Гараж
        Garage garage = new Garage();
        garage.parkCar(bmw);
        garage.parkCar(audi);
        garage.modifyCar(bmw, 50, 10);  // тюнинг
        garage.modifyCar(audi, 30, 15); // тюнинг

        System.out.println(garage);

        // Гонки
        Race drag = new DragRace(500, "Highway", 10000);
        drag.addParticipant(bmw);
        drag.addParticipant(audi);

        Race casual = new CasualRace(300, "City Circuit", 5000);
        casual.addParticipant(bmw);
        casual.addParticipant(audi);

        System.out.println("\nDrag Race Winner: " + drag.determineWinner());
        System.out.println("Casual Race Winner: " + casual.determineWinner());

        // Drift
        Race drift = new DriftRace(200, "Mountain Drift", 7000);
        drift.addParticipant(bmw);
        drift.addParticipant(audi);

        System.out.println("Drift Race Winner: " + drift.determineWinner());
    }
}