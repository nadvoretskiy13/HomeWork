package homeworks.homework16.cars;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int horsepower, int topSpeed, int stars) {
        super(brand, model, horsepower, topSpeed);
        this.stars = stars;
    }
}
