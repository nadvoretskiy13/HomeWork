package homeworks.homework16.repository;

import homeworks.homework16.cars.Car;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepositoryFileImpl implements CarRepository {
    private final Path filePath;

    public CarRepositoryFileImpl(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Car> getAllCars() {
        try {
            return Files.lines(filePath)
                    .map(line -> {
                        String[] parts = line.split(",");
                        return new Car(
                                parts[0].trim(),
                                parts[1].trim(),
                                Integer.parseInt(parts[2].trim()),
                                Integer.parseInt(parts[3].trim())
                        );
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла: " + filePath, e);
        }
    }
}

