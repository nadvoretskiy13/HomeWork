package homeworks.homework14;

import static org.junit.jupiter.api.Assertions.*;

import homeworks.homework14.Person;
import homeworks.homework14.Product;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PersonTest {

    // --- Позитивные тесты ---
    @Test
    void testAddProductSuccess() {
        Person person = new Person("Ivan", 50);
        Product bread = new Product("Bread", 10);

        String result = person.addProducts(bread);

        assertEquals("Ivan купил(а) Bread", result);
        assertEquals(40, person.getMoney());
        assertEquals(1, person.getProducts().length);
    }

    @Test
    void testToStringWhenNoProducts() {
        Person person = new Person("Maria", 100);
        assertEquals("Maria - Ничего не куплено", person.toString());
    }

    // --- Негативные тесты ---
    @Test
    void testAddProductFailNotEnoughMoney() {
        Person person = new Person("Alex", 5);
        Product tv = new Product("TV", 100);

        String result = person.addProducts(tv);

        assertEquals("Alex не может купить TV", result);
        assertEquals(5, person.getMoney()); // деньги не списаны
        assertEquals(0, person.getProducts().length);
    }

    // --- Тесты на исключения ---
    @Test
    void testSetNegativeMoneyThrowsException() {
        Person person = new Person("John", 100);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setMoney(-10);
        });
        assertEquals("Деньги не могут быть отрицательными", exception.getMessage());
    }

    @Test
    void testSetEmptyNameThrowsException() {
        Person person = new Person("John", 100);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setName("");
        });
        assertEquals("Имя не может быть пустым", exception.getMessage());
    }

    @Test
    void testConstructorWrongFormatThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("WrongFormatString");
        });
        assertTrue(exception.getMessage().contains("Неверный формат"));
    }

    // --- Игнорируемый тест ---
    @Disabled("Этот тест отключен для демонстрации @Disabled")
    @Test
    void testIgnored() {
        fail("Этот тест должен быть проигнорирован");
    }
}