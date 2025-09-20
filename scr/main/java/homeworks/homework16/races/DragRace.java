package main.java.homeworks.homework16.races;

import main.java.homeworks.homework16.cars.Car;

public class DragRace extends Race {

    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public Car determineWinner() {
        return getParticipants().stream()
                .max((c1, c2) -> Integer.compare(c1.getHorsepower() + c1.getHorsepower() / 2, c2.getHorsepower() + c2.getHorsepower() / 2))
                .orElse(null);
    }
}
