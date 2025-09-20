package main.java.homeworks.homework16.cars;

public class Car {
    private String brand;
    private String model;
    private int year;
    private int horsepower;
    private int suspension;
    private int durability;

    public Car(String brand, String model, int year, int horsepower, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.horsepower = horsepower;
        this.suspension = suspension;
        this.durability = durability;
    }

    public int getHorsepower() { return horsepower; }
    public int getSuspension() { return suspension; }
}



