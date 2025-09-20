package homeworks.homework16;

import homeworks.homework16.cars.PerformanceCar;
import homeworks.homework16.cars.ShowCar;
import homeworks.homework16.races.DragRace;
import homeworks.homework16.races.DriftRace;
import homeworks.homework16.races.CasualRace;

public class App16 {
    public static void main(String[] args) {
        PerformanceCar perfCar = new PerformanceCar(
                "Ferrari", "F8", 710, 2, 1480, 340, 2, 50
        );

        ShowCar showCar = new ShowCar(
                "Lamborghini", "Huracan", 640, 2, 1500, 325, 2, 40, true
        );

        DragRace dragRace = new DragRace(perfCar, showCar);
        DriftRace driftRace = new DriftRace(perfCar, showCar);
        CasualRace casualRace = new CasualRace(perfCar, showCar);

        dragRace.startRace();
        driftRace.startRace();
        casualRace.startRace();
    }
}


