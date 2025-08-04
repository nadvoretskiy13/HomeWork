package homeworks.homework09.races;

import homeworks.homework09.cars.Car;

public class DriftRace extends Race {
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public Car determineWinner() {
        return getParticipants().stream()
                .max((a, b) -> Integer.compare(a.getSuspension() + a.getDurability(), b.getSuspension() + b.getDurability()))
                .orElse(null);
    }
}
