package homeworks.homework16.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import homeworks.homework16.cars.Car;

import java.io.InputStream;
import java.util.List;

public class CarRepositoryFileImpl implements CarRepository {

    private List<Car> cars;

    public CarRepositoryFileImpl(String resourceFileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getClassLoader().getResourceAsStream(resourceFileName);
            if (is == null) {
                throw new RuntimeException("Resource not found: " + resourceFileName);
            }
            cars = mapper.readValue(is, new TypeReference<List<Car>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to load cars from file", e);
        }
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }
}

