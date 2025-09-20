package main.java.homeworks.homework16.cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int year, int horsepower, int suspension, int durability) {
        super(brand, model, year, horsepower, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    public List<String> getAddOns() { return addOns; }
}


