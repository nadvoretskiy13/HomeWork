package homeworks.homework16.repository;

import homeworks.homework16.cars.Car;
import homeworks.homework16.cars.PerformanceCar;
import homeworks.homework16.cars.ShowCar;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarRepositoryFileImplTest {

    private static CarRepositoryFileImpl repo;
    private static final String FILE_PATH = "cars_test.json";

    @BeforeAll
    static void setup() {
        repo = new CarRepositoryFileImpl(FILE_PATH);
    }

    @Test
    @Order(1)
    void testSaveAndLoadCars() throws Exception {
        List<Car> cars = List.of(
                new PerformanceCar("Ferrari", "F8", 2022, 710, 2, 340, 280_000),
                new ShowCar("Lamborghini", "Aventador", 2021, 770, 2, 350, 400_000, 5)
        );

        repo.saveCars(cars);
        List<Car> loadedCars = repo.loadCars();

        assertNotNull(loadedCars);
        assertEquals(2, loadedCars.size());
        assertEquals("Ferrari", loadedCars.get(0).getBrand());
        assertEquals("Aventador", loadedCars.get(1).getBrand());
    }

    @AfterAll
    static void cleanup() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }
}
