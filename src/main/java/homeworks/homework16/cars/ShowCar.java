package homeworks.homework16.cars;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ShowCar extends Car {

    public ShowCar(String name, int horsepower) {
        super(name, horsepower);
    }

    // Можно добавить свои методы специфические для ShowCar
}
