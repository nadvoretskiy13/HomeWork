package homeworks.homework16.cars;

public class Car {
    private String brand;
    private String model;
    private int year;
    private int horsepower;
    private int seats;
    private int topSpeed;
    private int price;

    public Car(String brand, String model, int year, int horsepower, int seats, int topSpeed, int price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.horsepower = horsepower;
        this.seats = seats;
        this.topSpeed = topSpeed;
        this.price = price;
    }

    public String getBrand() { return brand; }
    public int getHorsepower() { return horsepower; }
}

