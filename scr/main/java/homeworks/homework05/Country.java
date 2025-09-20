package main.java.homeworks.homework05;

public class Country {
    private String madeIn;
    public Country(String madeIn) {
        this.madeIn = madeIn;
    }
    public String getMadeIn() {
        return madeIn;
    }
    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }
    @Override
    public String toString() {
        return "in {" +
                " " + madeIn + '\'' +
                "}";
    }
}
