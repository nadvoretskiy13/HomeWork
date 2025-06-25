package homework02;

import java.util.Scanner;

public class task24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        for(int i = 1; i <= height; i++) {
            for (int j = 1; j <= height; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
