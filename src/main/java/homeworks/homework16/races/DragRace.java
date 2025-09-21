package homeworks.homework16.races;

import homeworks.homework16.cars.Car;
import java.util.List;

public class DragRace extends Race {

    public DragRace(String name, List<Car> participants) {
        super(name, participants);
    }

    @Override
    public Car startRace() {
        return participants.stream()
                .max((c1, c2) -> Integer.compare(c1.getHorsepower(), c2.getHorsepower()))
                .orElse(null);
    }
}
