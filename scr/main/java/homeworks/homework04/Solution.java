package main.java.homeworks.homework04;

import java.util.Arrays;
import java.util.Locale;

public class Solution {
    public String sortWordsAndLowercase(String inputLine) {
        String[] words = inputLine.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            result.append(new String(charArray).toLowerCase(Locale.ROOT)).append("  ");
        }

        return result.toString().trim();
    }
}
