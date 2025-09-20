package homeworks.homework16.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import homeworks.homework16.cars.Car;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CarRepositoryFileImpl implements CarRepository {
    private final String fileName;

    public CarRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Car> findAll() {
        homeworks.homework16.repository.ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (is == null) {
                throw new RuntimeException("Файл " + fileName + " не найден");
            }
            return mapper.readValue(is, new TypeReference<List<Car>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + fileName, e);
        }
    }
}
