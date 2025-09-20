package homeworks.homework16.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String brand;
    private String model;
    private int year;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    @Override
    public String toString() {
        return String.format("%s %s (%d) Л/С: %d, Ускорение: %d, Подвеска: %d, Долговечность: %d",
                brand, model, year, horsepower, acceleration, suspension, durability);
    }
}


