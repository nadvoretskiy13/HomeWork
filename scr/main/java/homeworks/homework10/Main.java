package main.java.homeworks.homework10;

public class Main {

    @FunctionalInterface
    interface ByCondition {
        boolean isOk(int number);
    }

    static class Sequence {
        public static int[] filter(int[] array, ByCondition condition) {
            return java.util.Arrays.stream(array)
                    .filter(condition::isOk)
                    .toArray();
        }
    }
    public static void main(String[] args) {
        int[] numbers = {12, 7, 45, 28, 33, 6, 91};

        // Условие: чётное число
        int[] evens = Sequence.filter(numbers, n -> n % 2 == 0);
        System.out.println("Чётные числа: " + java.util.Arrays.toString(evens));

        // Условие: сумма цифр — чётное число
        int[] sumEvenDigits = Sequence.filter(numbers, n -> {
            int sum = 0, temp = n;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            return sum % 2 == 0;
        });
        System.out.println("Числа с чётной суммой цифр: " + java.util.Arrays.toString(sumEvenDigits));
    }
}

