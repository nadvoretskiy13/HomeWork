package homework03;

public class Television {
    private String model;
    private int screenSize;
    private String screenResolution;
    private Country country;
    public Television(String model, int screenSize, String screenResolution, Country country) {
        this.model = model;
        this.screenSize = screenSize;
        this.screenResolution = screenResolution;
        this.country = country;
    }
    public Television(String model, int screenSize, String screenResolution) {
        this.model = model;
        this.screenSize = screenSize;
        this.screenResolution = screenResolution;
    }
    public Television(String model, int screenSize) {
        this.model = model;
        this.screenSize = screenSize;
    }
    public String toString() {
        return "Television{" +
                "model=" + model +
                ", screenSize" + screenSize +
                ", screenResolution" + screenResolution +
                ", country" + country +
                '}';
        }
    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }
    public String getScreenResolution() {
        return screenResolution;
    }
    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
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
}


