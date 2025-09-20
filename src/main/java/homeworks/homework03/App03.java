package homeworks.homework03;

/* Реализовать класс Телевизор. У класса есть поля, свойства и методы.
Проверить работу в классе App, методе main.
Обратить внимание на переопределение метода toString.
Ожидаемый результат:
1. Создан класс Телевизор;
2. У класса есть поля, свойства и методы. Поля желательно сделать private.
 Задать новые значения полям класса можно через конструктор и setters.
3. В классе переопределен метод toString.
4. Создан класс App с методом main
5. В методе main класса App создано несколько экземпляров класса
Телевизор и проверено, как распечатываются заполненные данные об
экземплярах класса.
6. Дополнительно. Задавать параметры класса Телевизор с клавиатуры
или случайным числом. */

import java.util.Scanner;

public class App03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String model = scan.nextLine();
        String country = scan.nextLine();
        int screenSize = scan.nextInt();
        int screenResolution = scan.nextInt();
        int productionYear = scan.nextInt();


        // конструктор по-умолчанию
        Country mainCountry = new Country(country);


        Television myTelevision = new Television(model, mainCountry, screenSize, screenResolution, productionYear);
        System.out.println(myTelevision);

        Television sTelevision = new Television(model, screenSize, productionYear);
        System.out.println(sTelevision);

        Television televisionWithCountry = new Television(model, screenSize);
        System.out.println(televisionWithCountry);

    }
}
