package homeworks.homework16.repository;

import homeworks.homework16.cars.Car;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryFileImplTest {
    @Test
    void testGetAllCars() {
        CarRepository repo = new CarRepositoryFileImpl(Paths.get("src/test/resources/test_cars.txt"));
        List<Car> cars = repo.getAllCars();
        assertEquals(2, cars.size());
        assertEquals("BMW", cars.get(0).getBrand());
        assertEquals(250, cars.get(1).getTopSpeed());
    }
}
