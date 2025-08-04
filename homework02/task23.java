package homework02;

import java.util.Scanner;

public class task23 {
    static final int height = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        for(int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                System.out.print("Java");
            }
            System.out.println();
        }
    }
}
