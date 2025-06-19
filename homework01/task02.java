package homework01;

import java.util.Random;

public class task02 {
    public static void main(String[] args) {
        Random rand = new Random();
        int petya = rand.nextInt(3);
        int vasya = rand.nextInt(3); // камень-0, ножницы-1, бумага-2.
        if (vasya == petya) {
            System.out.print("Ничья!");
        } else {
            if ((vasya == 1 && petya == 2) || (vasya == 0 && petya == 1)) {
                System.out.print("Победил Вася!" + " " + vasya + ">" + petya);
            } else {
                System.out.print("Победил Петя!" + " " + petya + ">" + vasya);
            }
        }
    }
}
