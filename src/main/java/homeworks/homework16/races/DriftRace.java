package homeworks.homework16.races;

import homeworks.homework16.cars.Car;

import java.util.Comparator;

public class DriftRace extends Race {
    public DriftRace(java.util.List<Car> participants) {
        super(participants);
    }

    @Override
    public Car start() {
        return participants.stream()
                .max(Comparator.comparingInt(Car::getTopSpeed))
                .orElse(null);
    }
}

