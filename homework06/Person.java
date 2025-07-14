package homework06;

public class Person {
    private String name;
    private Long money;
    private Product[] products = new Product[10];
    public Person(String name, Long money, Product[] products) {
        this.setName(name);
        this.setMoney(money);
        this.products = products;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }
    public Long getMoney() {
        return money;
    }
    public void setMoney(Long money) {
        if (money >= 0) {
            this.money = money;
        }
    }
    public Product[] getProducts() {
        return products;
    }
    public void addProduct(Product products) {
    }
}
