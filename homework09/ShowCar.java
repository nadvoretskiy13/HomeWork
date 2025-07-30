package homework09;

public class ShowCar extends Car {
    // Приватное поле для оценки популярности
    private int stars;

    // Конструктор по умолчанию
    public ShowCar() {
        super();
        this.stars = 0;
    }

    // Конструктор с параметрами
    public ShowCar(String brand, String model, int year, int power, int acceleration, int suspension, int durability) {
        super(brand, model, year, power, acceleration, suspension, durability);
        this.stars = 0;
    }

    // Геттер и сеттер для stars
    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "ShowCar{" +
                "stars=" + stars +
                '}' +
                super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShowCar showCar = (ShowCar) o;
        return stars == showCar.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }
}


