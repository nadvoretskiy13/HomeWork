package homework09;

public class Car {
    // Приватные поля
    private String brand;
    private String model;
    private int year;
    private int power;    // мощность в лошадиных силах
    private int acceleration;    // ускорение
    private int suspension;    // подвеска
    private int durability;    // долговечность

    // Конструктор по умолчанию
    public Car() {
    }

    // Конструктор с параметрами
    public Car(String brand, String model, int year, int power, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.power = power;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", power=" + power +
                ", acceleration=" + acceleration +
                ", suspension=" + suspension +
                ", durability=" + durability +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year &&
                power == car.power &&
                acceleration == car.acceleration &&
                suspension == car.suspension &&
                durability == car.durability &&
                brand.equals(car.brand) &&
                model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, power, acceleration, suspension, durability);
    }
}
