package homework06;

import java.util.Objects;

public class Product {

    private int bread;
    private int butter;
    private int cake;
    private int milk;
    private int instCoffe;

    public Product(int bread, int butter, int coffe, int cake, int milk) {
        this.bread = bread;
        this.butter = butter;
        this.cake = cake;
        this.milk = milk;
        this.instCoffe = coffe;
    }
    public int getBread() {
        return bread;}
    public void setBread(int bread) {
        this.bread = bread;}
    public int getButter() {
        return butter;
    }
    public void setButter(int butter) {
        this.butter = butter;
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
    public int getInstCoffe() {
        return instCoffe;
    }
    public void setInstCoffe(int instCoffe) {
        this.instCoffe = instCoffe;
    }
    @Override
    public String toString() {
        return "Product{" +
                "Хлеб=" + bread +
                ", Масло=" + butter +
                ", Кофе=" + instCoffe +
                ", Торт=" + cake +
                ", Молоко=" + milk +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return bread == product.bread && butter == product.butter && instCoffe == product.instCoffe && cake == product.cake && milk == product.milk;
    }
    @Override
    public int hashCode() {
        return Objects.hash(bread, butter, instCoffe, cake, milk);
    }
}
