package homeworks.homework16.races;

import lombok.Data;
import homeworks.homework16.cars.Car;
import java.util.List;

@Data
public abstract class Race {
    protected String name;
    protected List<Car> participants;

    public Race(String name, List<Car> participants) {
        this.name = name;
        this.participants = participants;
    }

    public abstract Car startRace();
}
