package homework02;

import java.util.Scanner;

public class task22 {
    static final int N = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        double srzn = (a + b) / N;
        System.out.println("Сумма двух целых чисел:" + " " + (a + b));
        System.out.println("Разница двух целых чисел:" + " " + Math.abs(a - b));
        System.out.println("Произведение из двух целых чисел:" + " " + (a * b));
        System.out.printf("Среднее из двух целых чисел: %.2f\n",srzn);
        System.out.println("Расстояние двух целых чисел:" + " " + Math.abs(a - b));
        System.out.println("Максимальное целое число:" + " " + Math.max(a, b));
        System.out.println("Минимальное целое число:" + " " + Math.min(a, b));




    }
}
