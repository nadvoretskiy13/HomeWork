package homeworks.homework16.cars;

import lombok.Getter;

@Getter
public class PerformanceCar extends Car {
    private int acceleration;

    public PerformanceCar(String make, String model, int horsepower, int topSpeed, int acceleration) {
        super(make, model, horsepower, topSpeed);
        this.acceleration = acceleration;
    }
}
