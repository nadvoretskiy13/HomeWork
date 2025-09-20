package homeworks.homework16.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import homeworks.homework16.cars.Car;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryFileImpl {
    private final String fileName;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CarRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    public void saveCars(List<Car> cars) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), cars);
        } catch (IOException e) {
            e.printStackTrace(); // можно заменить на логирование
        }
    }

    public List<Car> loadCars() {
        try {
            File file = new File(fileName);
            if (!file.exists()) return new ArrayList<>();
            return objectMapper.readValue(file, new TypeReference<List<Car>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}


