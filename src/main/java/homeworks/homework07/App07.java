package homeworks.homework07;
import java.util.Scanner;

public class App07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Массивы для хранения продуктов
        Product[] normalProducts = new Product[100];
        Product[] discountProducts = new Product[100];
        int normalCount = 0;
        int discountCount = 0;

        // Сообщение о начале заполнения корзины
        System.out.println("Начинаем заполнение корзины: ");

        // Считываем все строки до "END"
        String[] inputLines = new String[100];
        int inputCount = 0;

        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("END"))
                break;
            inputLines[inputCount++] = line;
        }

        // Обрабатываем каждую строку
        for (int i = 0; i < inputCount; i++) {
            String line = inputLines[i];

            // Проверяем корректность формата
            if (!line.contains("=")) {
                System.out.println("Неверный формат строки!");
                continue;
            }

            String[] parts = line.split("=");
            String name = parts[0].trim();

            // Проверка имени продукта
            if (name.length() < 3 || name.matches("\\d+")) {
                System.out.println("Недопустимое имя продукта!");
                continue;
            }

            String rightPart = parts[1].trim();
            if (rightPart.contains("%")) {
                // Скидочный продукт
                String[] priceAndDiscount = rightPart.split(",");
                if (priceAndDiscount.length != 2) {
                    System.out.println("Неверный формат скидочного продукта!");
                    continue;
                }

                double price = Double.parseDouble(priceAndDiscount[0].trim());
                int discount = Integer.parseInt(priceAndDiscount[1].trim().replace("%", ""));

                if (price <= 0) {
                    System.out.println("Недопустимая стоимость продукта!");
                    continue;
                }

                DiscountProduct dp = new DiscountProduct(name, price, discount, true);
                discountProducts[discountCount++] = dp;
            } else {
                // Обычный продукт
                double price = Double.parseDouble(rightPart);
                if (price <= 0) {
                    System.out.println("Недопустимая стоимость продукта!");
                    continue;
                }

                Product p = new Product(name, price);
                normalProducts[normalCount++] = p;
            }
        }

        // Выводим результаты
        System.out.print("Обычные продукты: ");
        if (normalCount == 0) {
            System.out.println("нет");
        } else {
            for (int i = 0; i < normalCount; i++) {
                System.out.print(normalProducts[i].getNameProduct());
                if (i != normalCount - 1) System.out.print(", ");
            }
            System.out.println();
        }

        System.out.print("Акционные продукты: ");
        if (discountCount == 0) {
            System.out.println("нет");
        } else {
            for (int i = 0; i < discountCount; i++) {
                System.out.print(discountProducts[i].getNameProduct());
                if (i != discountCount - 1) System.out.print(", ");
            }
            System.out.println();
        }

        scanner.close();
    }
}