package homeworks.homework09.races;

import homeworks.homework09.cars.Car;

public class DragRace extends Race {
    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public Car determineWinner() {
        return getParticipants().stream()
                .max((a, b) -> Integer.compare(a.getHorsepower(), b.getHorsepower()))
                .orElse(null);
    }
}
