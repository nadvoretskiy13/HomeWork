package homework06;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product bread = new Product("Хлеб", 40.0);
        Product milk = new Product("Молоко", 60.0);
        Product cake = new Product("Торт", 1000.0);
        Product coffee = new Product("Кофе растворимый", 879.0);
        Product butter = new Product("Масло", 150.0);



        Person pavel = new Person("Павел Андреевич", 10000.0);
        Person anna = new Person("Анна Петровна", 2000.0);
        Person boris = new Person("Борис", 10.0);

        pavel.addProduct(bread);

        System.out.println(pavel);





    }
}
