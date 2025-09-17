package homework14;

import main.java.homeworks.homework14.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    // --- Позитивные тесты с параметрами ---
    @ParameterizedTest
    @CsvSource({
            "Bread, 10",
            "Milk, 2",
            "Cheese, 15"
    })
    void testCreateProductFromString(String name, double price) {
        Product product = new Product(name + "=" + price);
        assertEquals(name, product.getNameProduct());
        assertEquals(price, product.getPrice());
    }

    @Test
    void testCreateProductWithConstructor() {
        Product product = new Product("Apple", 5);
        assertEquals("Apple", product.getNameProduct());
        assertEquals(5, product.getPrice());
    }

    // --- Негативные тесты ---
    @Test
    void testSetNegativePriceThrowsException() {
        Product product = new Product("Book", 20);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            product.setPrice(-1);
        });
        assertEquals("Стоимость продукта не может быть отрицательной", exception.getMessage());
    }

    @Test
    void testSetEmptyNameThrowsException() {
        Product product = new Product("Book", 20);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            product.setNameProduct("");
        });
        assertEquals("Название продукта не может быть пустым", exception.getMessage());
    }

    @Test
    void testConstructorWrongFormatThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product("OnlyName");
        });
        assertTrue(exception.getMessage().contains("Неверный формат"));
    }
}