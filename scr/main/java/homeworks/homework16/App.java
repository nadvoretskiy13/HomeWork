package main.java.homeworks.homework16;

import main.java.homeworks.homework16.cars.Car;
import main.java.homeworks.homework16.cars.PerformanceCar;
import main.java.homeworks.homework16.cars.ShowCar;
import main.java.homeworks.homework16.garage.Garage;
import main.java.homeworks.homework16.races.CasualRace;

public class App {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Supra", 2020, 320, 5, 150, 1000);
        PerformanceCar pCar = new PerformanceCar("BMW", "M3", 2021, 450, 4, 180, 1200);
        ShowCar sCar = new ShowCar("Audi", "R8", 2022, 610, 3, 220, 1300, 5);

        Garage garage = new Garage();
        garage.park(car1);
        garage.park(pCar);
        garage.park(sCar);

        System.out.println("Total Horsepower in garage: " + garage.getTotalHorsepower());

        CasualRace race = new CasualRace(500, "City Circuit", 10000);
        race.addParticipant(car1);
        race.addParticipant(pCar);
        race.addParticipant(sCar);

        System.out.println("Winner: " + race.determineWinner().getBrand());
    }
}

