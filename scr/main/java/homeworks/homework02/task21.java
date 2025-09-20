package main.java.homeworks.homework02;

import java.util.Scanner;

public class task21 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int F = scan.nextInt();
        double C = (F - 32)*5/9; // одна из формул перевода Фаренгейта в Цельсия
        System.out.println(C);
    }
}
