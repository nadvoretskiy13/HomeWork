package homework07;

import java.util.Objects;

public class DiscountProduct extends Product {

    private double discount;
    private boolean discountIsOn = false;

    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public boolean isDiscountIsOn() {
        return discountIsOn;
    }
    public void setDiscountIsOn(boolean discountIsOn) {
        this.discountIsOn = discountIsOn;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return Double.compare(discount, that.discount) == 0 && discountIsOn == that.discountIsOn;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, discountIsOn);
    }
    public DiscountProduct(String nameProduct, double price, double discount, boolean discountIsOn) {
        super(nameProduct, price);
        this.discount = discount;
        this.discountIsOn = discountIsOn;
    }
}
