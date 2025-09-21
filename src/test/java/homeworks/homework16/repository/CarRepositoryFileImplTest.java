package homeworks.homework16.repository;

import homeworks.homework16.cars.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryFileImplTest {

    private CarRepositoryFileImpl carRepo;

    @BeforeEach
    void setUp() {
        // Подключаем тестовый файл из src/test/resources
        String path = Paths.get("src/test/resources/test_cars.txt").toAbsolutePath().toString();
        carRepo = new CarRepositoryFileImpl(path);
    }

    @Test
    void testLoadCars() {
        List<Car> cars = carRepo.getAllCars();
        assertNotNull(cars, "Список машин не должен быть null");
        assertEquals(3, cars.size(), "Должно быть 3 машины в списке");

        assertEquals("CarA", cars.get(0).getName());
        assertEquals(120, cars.get(0).getTopSpeed());

        assertEquals("CarB", cars.get(1).getName());
        assertEquals(150, cars.get(1).getTopSpeed());

        assertEquals("CarC", cars.get(2).getName());
        assertEquals(180, cars.get(2).getTopSpeed());
    }
}
