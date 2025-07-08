package homework05;

public class Television {
    private String model;
    private int screenSize;
    private int screenResolution;
    private int productionYear;
    private int channelNumber;
    private int volumeLVL;
    private boolean power;
    private Country country;
    public Television(String model, Country country, int screenSize, int screenResolution, int productionYear, int channelNumber, int volumeLVL, boolean power) {
        this.model = model;
        this.screenSize = screenSize;
        this.productionYear = productionYear;
        this.screenResolution = screenResolution;
        this.country = country;
        this.channelNumber = channelNumber;
        this.volumeLVL = volumeLVL;
        this.power = power;
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
                ", Канал " + channelNumber + '\'' +
                ", Громкость " + volumeLVL + '\'' +
                ", Вкл/Выкл " + power + '\'' +
                '}';
    }
    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}
    public int getScreenSize() {return screenSize;}
    public void setScreenSize(int screenSize) {this.screenSize = screenSize;}
    public int getScreenResolution() {return screenResolution;}
    public void setScreenResolution(int screenResolution) {this.screenResolution = screenResolution;}
    public int getProductionYear() {return productionYear;}
    public void setProductionYear(int productionYear) {this.productionYear = productionYear;}
    public int getChanelNumber() {return channelNumber;}
    public void setChanelNumber(int chanelNumber) {this.channelNumber = chanelNumber;}
    public int getVolumeLVL() {return volumeLVL;}
    public void setVolumeLVL(int volumeLVL) {this.volumeLVL = volumeLVL;}
    public boolean isPower() {return power;}
    public void setPower(boolean power) {this.power = power;}
    public Country getCountry() {return country;}
    public void setCountry(Country country) {this.country = country;}
}
