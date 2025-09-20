package homeworks.homework16.races;

import homeworks.homework16.cars.Car;

public class DriftRace extends Race {

    public DriftRace(Car c1, Car c2) {
        super(c1, c2);
    }

    @Override
    public void startRace() {
        Car winner = (c1.getTopSpeed() > c2.getTopSpeed()) ? c1 : c2;
        System.out.println("DriftRace winner: " + winner.getMake() + " " + winner.getModel());
    }
}
