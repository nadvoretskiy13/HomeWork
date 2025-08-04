package homework01;

import java.util.Random;

public class task01 {
    public static void main(String[] args) {
        Random rand = new Random();
        int a = rand.nextInt(100);
        int b = rand.nextInt(100);
        int c = rand.nextInt(100);
        int d = rand.nextInt(100);
        System.out.println(a+"   "+b+"   "+c+"   "+d);
    }
}