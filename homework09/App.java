package homework09;

public class App {
    public static void main(String[] args) {
        // Создаем базовые автомобили
        Car car1 = new Car("Toyota", "Camry", 2020, 180, 8, 5, 100);
        Car car2 = new Car("BMW", "M5", 2021, 600, 3, 7, 90);

        // Создаем специализированные автомобили
        PerformanceCar perfCar = new PerformanceCar("Ferrari", "F8", 2021, 600, 3, 8, 80);
        ShowCar showCar = new ShowCar("Lamborghini", "Aventador", 2022, 700, 2, 7, 90);

        // Добавляем дополнения к гоночному автомобилю
        perfCar.getAddOns().add("Турбонаддув");
        perfCar.getAddOns().add("Спортивные тормоза");

        // Создаем гонки
        Race casualRace = new Race(10000, "Городская трасса", 100000);
        DragRace dragRace = new DragRace(402, "Драг-стрип", 50000);
        DriftRace driftRace = new DriftRace(2000, "Дрифт-арена", 75000);

        // Добавляем участников в гонки
        casualRace.addParticipant(car1);
        casualRace.addParticipant(car2);
        dragRace.addParticipant(perfCar);
        driftRace.addParticipant(showCar);

        // Создаем гараж и добавляем автомобили
        Garage garage = new Garage();
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(perfCar);
        garage.addCar(showCar);

        // Выводим информацию
        System.out.println("Список автомобилей в гараже:");
        for (Car car : garage.getParkedCars()) {
            System.out.println(car.toString());
        }

        // Пример модификации автомобиля
        System.out.println("\nМодифицируем автомобиль:");
        garage.modifyCar(car1, "Улучшенная подвеска");
        System.out.println(car1.toString());

        // Выводим информацию о гонках
        System.out.println("\nИнформация о гонках:");
        System.out.println(casualRace.toString());
        System.out.println(dragRace.toString());
        System.out.println(driftRace.toString());
    }
}