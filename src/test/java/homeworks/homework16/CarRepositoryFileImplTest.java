package homeworks.homework16;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryFileImplTest {

    @Test
    void testGetAllCars() {
        CarRepository repository = new CarRepositoryFileImpl(Path.of("src/test/resources/cars_test.txt"));
        List<Car> cars = repository.getAllCars();
        assertEquals(2, cars.size());
        assertEquals("Toyota", cars.get(0).getBrand());
        assertEquals("Corolla", cars.get(0).getModel());
        assertEquals(2020, cars.get(0).getYear());
    }
}
