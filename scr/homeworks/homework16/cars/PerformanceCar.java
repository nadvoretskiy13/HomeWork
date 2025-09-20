package homeworks.homework16.cars;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PerformanceCar extends Car {
    private List<String> addOns = new ArrayList<>();

    public PerformanceCar(String brand, String model, int year,
                          int horsepower, int acceleration,
                          int suspension, int durability) {
        super(brand, model, year,
                (int) (horsepower * 1.5),
                acceleration,
                (int) (suspension * 0.75),
                durability);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Дополнения: " +
                (addOns.isEmpty() ? "None" : String.join(", ", addOns));
    }
}


