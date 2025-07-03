package homework04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task2 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.next();

        Pattern pattern = Pattern.compile(">>-->");
        Pattern pattern1 = Pattern.compile("<--<<");

        Matcher matcher = pattern.matcher(input);
        Matcher matcher1 = pattern1.matcher(input);

        int arrow = 0;
        int arrow2 = 0;
        while (matcher.find()) {
            arrow++;
        }
        while (matcher1.find()) {
            arrow2++;
        }
        System.out.println(arrow + arrow2);
    }
}
