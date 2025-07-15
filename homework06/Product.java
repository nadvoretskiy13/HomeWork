package homework06;

import java.util.Objects;

public class Product {

    private int bread;
    private int butter;
    private int Coffe;
    private int cake;
    private int milk;

    public int getBread() {
        return bread;
    }
    public void setBread(int bread) {
        this.bread = bread;
    }
    public int getButter() {
        return butter;
    }
    public void setButter(int butter) {
        this.butter = butter;
    }
    public int getCoffe() {
        return Coffe;
    }
    public void setCoffe(int coffe) {
        Coffe = coffe;
    }
    public int getCake() {
        return cake;
    }
    public void setCake(int cake) {
        this.cake = cake;
    }
    public int getMilk() {
        return milk;
    }
    public void setMilk(int milk) {
        this.milk = milk;
    }
    @Override
    public String toString() {
        return "Product{" +
                "Хлеб=" + bread +
                ", Масло=" + butter +
                ", Кофе=" + Coffe +
                ", Торт=" + cake +
                ", Молоко=" + milk +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return bread == product.bread && butter == product.butter && Coffe == product.Coffe && cake == product.cake && milk == product.milk;
    }
    @Override
    public int hashCode() {
        return Objects.hash(bread, butter, Coffe, cake, milk);
    }
}
