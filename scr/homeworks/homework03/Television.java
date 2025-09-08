package homeworks.homework03;

public class Television {
    private String model;
    private int screenSize;
    private int screenResolution;
    private Country country;
    private int productionYear;

    public Television(String model, Country country, int screenSize, int screenResolution, int productionYear) {
        this.model = model;
        this.screenSize = screenSize;
        this.productionYear = productionYear;
        this.screenResolution = screenResolution;
        this.country = country;
    }
    public Television(String model, int screenSize, int productionYear) {
        this.model = model;
        this.productionYear = productionYear;
        this.screenSize = screenSize;
    }
    public Television(String model, int screenSize) {
        this.model = model;
        this.screenSize = screenSize;
    }
    @Override
    public String toString() {
        return "Телевизор{" +
                "Модель " + model + '\'' +
                ", Made " + country + '\'' +
                ", Диагональ " + screenSize + '\'' +
                ", Разрешение экрана " + screenResolution + '\'' +
                ", Год начала производства " + productionYear + '\'' +
                '}';
    }
    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }
    public int getScreenSize() {
        return screenSize;
    }
    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getProductionYear() {
        return productionYear;
    }
    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }
    public int getScreenResolution() {
        return screenResolution;
    }
    public void setScreenResolution(int screenResolution) {
        this.screenResolution = screenResolution;
    }
}
