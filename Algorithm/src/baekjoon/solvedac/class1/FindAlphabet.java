package baekjoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindAlphabet {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s = reader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (char a = 'a'; a <= 'z'; a++) {
            if (s.contains(String.valueOf(a))) {
                stringBuilder.append(s.indexOf(String.valueOf(a))).append(" ");
            } else {
                stringBuilder.append(-1).append(" ");
            }
        }

        System.out.println(stringBuilder);
    }
}
