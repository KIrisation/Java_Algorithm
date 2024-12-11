package baekjoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordsNumber {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] split = reader.readLine()
                               .trim()
                               .split(" ");

        if (split.length == 1) {
            if (split[0].equals("")) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(split.length);
    }
}
