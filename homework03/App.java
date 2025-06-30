package homework03;

// Реализовать класс Телевизор. У класса есть поля, свойства и методы.
//Проверить работу в классе App, методе main.
//Обратить внимание на переопределение метода toString.


import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        // конструктор по-умолчанию
        Television myTelevision = new Television();
        myTelevision.productionDate = LocalDate.now();
        System.out.println(myTelevision);
    }
}
