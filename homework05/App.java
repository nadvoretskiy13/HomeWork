package homework05;

/* Дополнительная задача:
Доработать класс Телевизор:
1. В класс Телевизор добавить поля (если не были добавлены ранее):
1) Номер включенного канала — integer;
2) Громкость звука — integer (от 0 до 100);
3) Признак включенного телевизора — boolean.
2. Переопределить метод toString класса Телевизор таким образом, чтобы
распечатывались: название класса, все поля класса и их значения.
3. Добавить в класс Телевизор методы equals и hashcode.
На вход программы в классе App, методе main подается информация о
телевизорах в количестве 10 телевизоров. Считать данные в массив объектов
(можно выполнить считывание данных в цикле). В каждом из 10 экземпляров
класса должны быть заполнены следующие поля:
a. Как минимум, 1 поле по выбору, добавленное студентом в задании 3;
b. Номер включенного канала - целое число,
c. Громкость звука - целое число;
d. Признак включен ли телевизор.
Считать с клавиатуры число допустимого значения громкости звука
maxVolume (рекомендуется ввести с клавиатуры целое число от 50 до 70).
Далее необходимо в цикле вывести только включенные телевизоры, у
которых звук является допустимым (меньшим или равным maxVolume).
Дополнительно. Добавить в массив Телевизоров сортировку по номеру
канала (по возрастанию).
Планируемый результат:
1. 2. Ссылка на программу и отчёт со скриншотами в репозитории github;
Архив с программой и отчётом со скриншотами выполнения задач. */

import java.util.Scanner;

public class App {
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
