package homeworks.homework16;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        CarRepository repository = new CarRepositoryFileImpl(Path.of("src/main/resources/cars.txt"));
        repository.getAllCars().forEach(System.out::println);
    }
}
