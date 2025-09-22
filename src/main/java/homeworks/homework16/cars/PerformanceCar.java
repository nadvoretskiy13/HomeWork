package homeworks.homework16.cars;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PerformanceCar extends Car {
    private double acceleration;

    public PerformanceCar(String brand, String model, int horsepower, int topSpeed, double acceleration) {
        super(brand, model, horsepower, topSpeed);
        this.acceleration = acceleration;
    }
}

