package homework09;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    // Приватное поле для хранения автомобилей
    private List<Car> parkedCars;

    // Конструктор по умолчанию
    public Garage() {
        parkedCars = new ArrayList<>();
    }

    // Метод добавления автомобиля в гараж
    public void addCar(Car car) {
        parkedCars.add(car);
    }

    // Метод удаления автомобиля из гаража
    public boolean removeCar(Car car) {
        return parkedCars.remove(car);
    }

    // Метод модификации автомобиля
    public void modifyCar(Car car, String modification) {
        // Здесь можно добавить логику модификации
        // Например, изменение характеристик автомобиля
        if (car instanceof PerformanceCar) {
            PerformanceCar perfCar = (PerformanceCar) car;
            perfCar.getAddOns().add(modification);
        }
        // Добавить другие типы модификаций для разных типов автомобилей
    }

    // Геттер для получения списка припаркованных автомобилей
    public List<Car> getParkedCars() {
        return parkedCars;
    }

    // Сеттер для установки списка автомобилей
    public void setParkedCars(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "parkedCars=" + parkedCars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return parkedCars.equals(garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return parkedCars.hashCode();
    }
}
