package homework09.garage;

import homework09.cars.Car;
import homework09.cars.PerformanceCar;
import homework09.cars.ShowCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Garage {
    private List<Car> parkedCars = new ArrayList<>();

    public void parkCar(Car car) {
        parkedCars.add(car);
    }

    public void unparkCar(Car car) {
        parkedCars.remove(car);
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public void modifyCar(Car car, int tunePower, int tuneSuspension) {
        if (parkedCars.contains(car)) {
            car.setHorsepower(car.getHorsepower() + tunePower);
            car.setSuspension(car.getSuspension() + tuneSuspension);

            if (car instanceof ShowCar) {
                ShowCar sc = (ShowCar) car;
                sc.setStars(sc.getStars() + 1);
            }

            if (car instanceof PerformanceCar) {
                PerformanceCar pc = (PerformanceCar) car;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Garage)) return false;
        Garage garage = (Garage) o;
        return Objects.equals(parkedCars, garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkedCars);
    }
}
