package homeworks.homework16.races;

import homeworks.homework16.cars.Car;

public class DragRace extends Race {

    public DragRace(Car c1, Car c2) {
        super(c1, c2);
    }

    @Override
    public void startRace() {
        Car winner = (c1.getHorsepower() > c2.getHorsepower()) ? c1 : c2;
        System.out.println("DragRace winner: " + winner.getMake() + " " + winner.getModel());
    }
}
