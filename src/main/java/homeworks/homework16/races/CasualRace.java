package homeworks.homework16.races;

import homeworks.homework16.cars.Car;

import java.util.Random;

public class CasualRace extends Race {
    public CasualRace(java.util.List<Car> participants) {
        super(participants);
    }

    @Override
    public Car start() {
        if (participants.isEmpty()) return null;
        return participants.get(new Random().nextInt(participants.size()));
    }
}

