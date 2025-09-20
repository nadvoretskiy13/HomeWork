package homeworks.homework16.repository;

import homeworks.homework16.cars.Car;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryFileImplTest {

    @Test
    void testFindAll() {
        CarRepository repo = new CarRepositoryFileImpl("cars-test.json");
        List<Car> cars = repo.findAll();

        assertNotNull(cars);
        assertEquals(2, cars.size());
        assertEquals("BMW", cars.get(0).getBrand());
    }
}
