package homeworks.homework16.garage;

import homeworks.homework16.cars.Car;
import homeworks.homework16.cars.PerformanceCar;
import homeworks.homework16.cars.ShowCar;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Garage {
    private List<Car> parkedCars = new ArrayList<>();

    public void parkCar(Car car) {
        parkedCars.add(car);
    }

    public void unparkCar(Car car) {
        parkedCars.remove(car);
    }

    public void modifyCar(Car car, int tunePower, int tuneSuspension) {
        if (parkedCars.contains(car)) {
            car.setHorsepower(car.getHorsepower() + tunePower);
            car.setSuspension(car.getSuspension() + tuneSuspension);

            if (car instanceof ShowCar sc) {
                sc.setStars(sc.getStars() + 1);
            }

            if (car instanceof PerformanceCar pc) {
                pc.getAddOns().add("Тюнингованный выхлоп");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Содержание гаража:\n");
        for (Car c : parkedCars) {
            sb.append("- ").append(c).append("\n");
        }
        return sb.toString();
    }
}

