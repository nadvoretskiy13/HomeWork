package homeworks.homework16.races;

import homeworks.homework16.cars.Car;

public class DriftRace extends Race {

    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public Car determineWinner() {
        return getParticipants().stream()
                .max((c1, c2) -> Integer.compare(c1.getHorsepower() / 2, c2.getHorsepower() / 2))
                .orElse(null);
    }
}
