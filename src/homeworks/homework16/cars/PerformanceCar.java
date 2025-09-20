package homeworks.homework16.cars;

public class PerformanceCar extends Car {
    private int addOns;

    public PerformanceCar(String brand, String model, int year, int horsepower, int seats, int topSpeed, int price) {
        super(brand, model, year, horsepower, seats, topSpeed, price);
        this.addOns = 0;
    }

    public int getAddOns() {
        return addOns;
    }

    public void addAddon() {
        addOns++;
    }
}


