package main.java.homeworks.homework13;

public class InputParser {

    /**
     * Парсит строковое значение в число.
     * Сначала пытается преобразовать в Integer, если не влезает — пробует Long.
     * @param value строка, которую нужно распарсить
     * @return число (Integer или Long)
     * @throws IllegalArgumentException если значение некорректное
     */
    public static Number parseCount(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e1) {
            try {
                return Long.parseLong(value);
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException("Невалидное значение");
            }
        }
    }

    /**
     * Проверяет корректность ввода и возвращает число или сообщение об ошибке.
     * @param value строка для проверки
     * @return результат парсинга (строкой) или сообщение об ошибке
     */
    public static String validateCount(String value) {
        try {
            Number result = parseCount(value);
            return String.valueOf(result);
        } catch (IllegalArgumentException e) {
            return e.getMessage(); // "Невалидное значение"
        }
    }
}
