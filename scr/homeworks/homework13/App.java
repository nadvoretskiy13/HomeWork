package homeworks.homework13;

public class App {
    public static void main(String[] args) {
        // Влезает в Integer
        System.out.println(InputParser.validateCount("123"));
        // -> 123

        // В Integer не влезает, но влезает в Long
        System.out.println(InputParser.validateCount("9999999999"));
        // -> 9999999999

        // Некорректный ввод
        System.out.println(InputParser.validateCount("12a3"));
        // -> Невалидное значение

        // Число слишком большое даже для Long
        System.out.println(InputParser.validateCount("9999999999999999999999999"));
        // -> Невалидное значение
    }
}
