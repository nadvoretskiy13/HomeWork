package homeworks.homework11;

class Car {
    private String number;
    private String model;
    private String color;
    private long mileage;
    private long cost;

    public Car(String number, String model, String color, long mileage, long cost) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.cost = cost;
    }

    public String getNumber() { return number; }
    public String getModel() { return model; }
    public String getColor() { return color; }
    public long getMileage() { return mileage; }
    public long getCost() { return cost; }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %d", number, model, color, mileage, cost);
    }
}
