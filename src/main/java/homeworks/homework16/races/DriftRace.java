package homeworks.homework16.races;

import homeworks.homework16.cars.Car;

public class DriftRace {
    private final Car c1;
    private final Car c2;

    public DriftRace(Car c1, Car c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public void startRace() {
        System.out.println("Drift race: " + c1.getName() + " vs " + c2.getName());
    }
}
