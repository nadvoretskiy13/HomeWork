package homeworks.homework09.cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PerformanceCar extends Car {
    private List<String> addOns = new ArrayList<>();

    public PerformanceCar() {
        super();
    }

    public PerformanceCar(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, year, (int)(horsepower * 1.5), acceleration, (int)(suspension * 0.75), durability);
    }

    public List<String> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<String> addOns) {
        this.addOns = addOns;
    }

    @Override
    public String toString() {
        return super.toString() + ", Дополнения: " + (addOns.isEmpty() ? "None" : String.join(", ", addOns));
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        PerformanceCar that = (PerformanceCar) o;
        return Objects.equals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), addOns);
    }
}

