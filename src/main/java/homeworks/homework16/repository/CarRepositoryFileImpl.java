package homeworks.homework16.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import homeworks.homework16.cars.Car;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryFileImpl {
    private final String filename;
    private final ObjectMapper mapper;

    public CarRepositoryFileImpl(String filename) {
        this.filename = filename;
        this.mapper = new ObjectMapper();
    }

    public void saveCars(List<Car> cars) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Car> loadCars() {
        File file = new File(filename);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try {
            return mapper.readValue(file, new TypeReference<List<Car>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

