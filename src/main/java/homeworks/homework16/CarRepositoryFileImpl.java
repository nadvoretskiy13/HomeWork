package homeworks.homework16;

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
                    .filter(line -> !line.trim().isEmpty())
                    .map(line -> {
                        String[] parts = line.split(",");
                        if (parts.length < 3) {
                            throw new IllegalArgumentException("Invalid line: " + line);
                        }
                        return new Car(parts[0].trim(), parts[1].trim(), Integer.parseInt(parts[2].trim()));
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read cars file", e);
        }
    }
}
