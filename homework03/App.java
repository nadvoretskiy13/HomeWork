package homework03;

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

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // конструктор по-умолчанию

        Television myTelevision = new Television ("Philips",70 ,"3840x2160");
        System.out.println(myTelevision);

        Television sTelevision = new Television ("Samsung",65);
        System.out.println(sTelevision);

        Country mainCountry = new Country("China", 2023);
        Television televisionWithCountry = new Television ("Xiaomi",55 ,"3840x2160", mainCountry);
        System.out.println(televisionWithCountry);

    }
}
