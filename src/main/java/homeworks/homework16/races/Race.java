package homeworks.homework16.races;

import homeworks.homework16.cars.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public abstract class Race {
    protected List<Car> participants;

    public abstract Car start();
}


