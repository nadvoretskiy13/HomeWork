package homeworks.homework16.cars;

import lombok.Getter;

@Getter
public class ShowCar extends Car {
    private boolean isModified;

    public ShowCar(String make, String model, int horsepower, int topSpeed, boolean isModified) {
        super(make, model, horsepower, topSpeed);
        this.isModified = isModified;
    }
}
