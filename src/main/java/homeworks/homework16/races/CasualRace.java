package homeworks.homework16.races;

import homeworks.homework16.cars.Car;

public class CasualRace {
    private final Car c1;
    private final Car c2;

    public CasualRace(Car c1, Car c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public void startRace() {
        System.out.println("Casual race: " + c1.getName() + " vs " + c2.getName());
    }
}
