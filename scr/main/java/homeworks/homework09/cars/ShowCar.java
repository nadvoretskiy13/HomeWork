package main.java.homeworks.homework09.cars;

import java.util.Objects;

public class ShowCar extends Car {
    private int stars = 0;

    public ShowCar() {
        super();
    }

    public ShowCar(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, year, horsepower, acceleration, suspension, durability);
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return super.toString() + ", Звезды: " + stars;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        ShowCar showCar = (ShowCar) o;
        return stars == showCar.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }
}


