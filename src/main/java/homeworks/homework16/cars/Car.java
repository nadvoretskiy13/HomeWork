package homeworks.homework16.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // добавляем пустой конструктор для super()
public class Car {
    private String name;
    private int horsepower;

    // Пример метода getTopSpeed для Garage
    public int getTopSpeed() {
        return horsepower * 2; // можно заменить на реальную формулу
    }
}

