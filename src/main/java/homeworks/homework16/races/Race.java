package homeworks.homework16.races;

import homeworks.homework16.cars.Car;
import lombok.Getter;

@Getter
public abstract class Race {
    protected Car c1;
    protected Car c2;

    public Race(Car c1, Car c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public abstract void startRace();
}
