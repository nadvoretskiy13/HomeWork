package homeworks.homework04;


import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = "qwertyuiopasdfghjklzxcvbnm";
        String input = scan.next();
        if (string.indexOf(input) == 0) {
            System.out.println(string.charAt(string.length() - 1));
        } else {
            System.out.println(string.charAt(string.indexOf(input) - 1));
        }
    }
}
