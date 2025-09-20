package main.java.homeworks.homework16.cars;

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int year, int horsepower, int seats, int topSpeed, int price, int stars) {
        super(brand, model, year, horsepower, seats, topSpeed, price);
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }
}

