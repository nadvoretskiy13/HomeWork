package homework06;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Product bread = new Product("Хлеб", 40.0);
        Product milk = new Product("Молоко", 60.0);
        Product cake = new Product("Торт", 1000.0);
        Product coffee = new Product("Кофе растворимый", 879.0);
        Product butter = new Product("Масло", 150.0);
        Product iceCream = new Product("Мороженное", 200.0);
        Product pasta = new Product("Макароны", 800.0);

        Person pavel = new Person("Павел Андреевич", 10000.0);
        Person anna = new Person("Анна Петровна", 2000.0);
        Person boris = new Person("Борис", 10.0);
        Person jane = new Person("Женя", 0.0);
        Person sveta = new Person("Света", -3.0);

        pavel.addProduct(bread);
        pavel.addProduct(butter);
        pavel.addProduct(cake);
        anna.addProduct(coffee);
        anna.addProduct(milk);
        anna.addProduct(milk);
        anna.addProduct(milk);
        anna.addProduct(cake);
        boris.addProduct(cake);

        System.out.println(pavel.toString().replace("[", "").replace("]", ""));
        System.out.println(anna.toString().replace("[", "").replace("]", ""));
        System.out.println(boris.toString().replace("[", "").replace("]", ""));





    }
}
