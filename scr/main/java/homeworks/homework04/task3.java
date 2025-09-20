package main.java.homeworks.homework04;

import java.util.Scanner;

public class task3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Solution solution = new Solution();
        String input = scan.nextLine();
        String sortedAndLowercased = solution.sortWordsAndLowercase(input);
        System.out.println(sortedAndLowercased);
    }
}
