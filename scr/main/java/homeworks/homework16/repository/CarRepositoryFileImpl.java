package main.java.homeworks.homework16.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import main.java.homeworks.homework16.cars.Car;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryFileImpl {

    private final File file;
    private final ObjectMapper objectMapper;

    public CarRepositoryFileImpl(String filePath) {
        this.file = new File(filePath);
        this.objectMapper = new ObjectMapper();
    }

    public void saveCars(List<Car> cars) throws IOException {
        objectMapper.writeValue(file, cars);
    }

    public List<Car> loadCars() throws IOException {
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }
        return objectMapper.readValue(file, new TypeReference<List<Car>>() {});
    }
}
