package homeworks.homework16.cars;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ShowCar extends Car {
    private int stars = 0;

    public ShowCar(String brand, String model, int year,
                   int horsepower, int acceleration,
                   int suspension, int durability) {
        super(brand, model, year, horsepower, acceleration, suspension, durability);
    }

    @Override
    public String toString() {
        return super.toString() + ", Звезды: " + stars;
    }
}



