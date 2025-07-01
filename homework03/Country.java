package homework03;

public class Country {
    private String madeIn;
    private int productionYear;

    public Country(String madeIn, int productionYear) {
        this.madeIn = madeIn;
        this.productionYear = productionYear;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String toString() {
        return "Television{" +
                "madeIn=" + madeIn +
                ", productionYear" + productionYear +
                '}';
    }
}
