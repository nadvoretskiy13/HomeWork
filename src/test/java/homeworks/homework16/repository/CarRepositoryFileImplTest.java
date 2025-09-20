package homeworks.homework16.repository;

import homeworks.homework16.cars.Car;
import homeworks.homework16.cars.PerformanceCar;
import homeworks.homework16.cars.ShowCar;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarRepositoryFileImplTest {

    private static final String TEST_FILE = "test_cars.json";

    @Test
    void testSaveAndLoadCars() {
        CarRepositoryFileImpl repository = new CarRepositoryFileImpl(TEST_FILE);

        PerformanceCar perfCar = new PerformanceCar(
                "Ferrari", "F8", 710, 2, 1480, 340, 2, 50
        );
        ShowCar showCar = new ShowCar(
                "Lamborghini", "Huracan", 640, 2, 1500, 325, 2, 40, true
        );

        List<Car> carsToSave = new ArrayList<>();
        carsToSave.add(perfCar);
        carsToSave.add(showCar);

        repository.saveCars(carsToSave);

        List<Car> loadedCars = repository.loadCars();

        assertEquals(2, loadedCars.size());
        assertEquals(perfCar.getMake(), loadedCars.get(0).getMake());
        assertEquals(showCar.getMake(), loadedCars.get(1).getMake());

        // Удаляем файл после теста
        new File(TEST_FILE).delete();
    }
}
