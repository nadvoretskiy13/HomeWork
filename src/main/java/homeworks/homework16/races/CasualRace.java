package homeworks.homework16.races;

import homeworks.homework16.cars.Car;

public class CasualRace extends Race {

    public CasualRace(Car c1, Car c2) {
        super(c1, c2);
    }

    @Override
    public void startRace() {
        int score1 = c1.getHorsepower() + c1.getTopSpeed();
        int score2 = c2.getHorsepower() + c2.getTopSpeed();
        Car winner = (score1 > score2) ? c1 : c2;
        System.out.println("CasualRace winner: " + winner.getMake() + " " + winner.getModel());
    }
}
