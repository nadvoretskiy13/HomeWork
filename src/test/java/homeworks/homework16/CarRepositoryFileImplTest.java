package homeworks.homework16;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarRepositoryFileImplTest {

    @Test
    void testGetAllCars() {
        CarRepository repository = new CarRepositoryFileImpl(Path.of("src/test/resources/test_cars.txt"));
        List<Car> cars = repository.getAllCars();
        assertEquals(2, cars.size());
        assertEquals("Honda", cars.get(0).getBrand());
        assertEquals("Civic", cars.get(0).getModel());
    }
}

