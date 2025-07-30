package homework09;

public class PerformanceCar extends Car {
    // Массив для дополнительных модификаций
    private String[] addOns;

    // Конструктор по умолчанию
    public PerformanceCar() {
        super();
        addOns = new String[0];
    }

    // Конструктор с параметрами
    public PerformanceCar(String brand, String model, int year, int power, int acceleration, int suspension, int durability) {
        // Применяем модификаторы для гоночного автомобиля
        super(brand, model, year,
                (int) (power * 1.5),    // Увеличиваем мощность на 50%
                acceleration,
                (int) (suspension * 0.75), // Уменьшаем подвеску на 25%
                durability);
        addOns = new String[0];
    }

    // Геттер и сеттер для addOns
    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns;
    }

    @Override
    public String toString() {
        return "PerformanceCar{" +
                "addOns=" + Arrays.toString(addOns) +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerformanceCar that = (PerformanceCar) o;
        return Arrays.equals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(addOns);
        return result;
    }
}

