package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DateCalculation {

    public static int e;
    public static int s;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String[] s2 = s1.split(" ");
        e = Integer.parseInt(s2[0]) - 1;
        s = Integer.parseInt(s2[1]) - 1;
        m = Integer.parseInt(s2[2]) - 1;

        int i = 0;
        while (true) {
            if (i % 15 == e && i % 28 == s && i % 19 == m) {
                System.out.println(i + 1);
                break;
            }
            i++;
        }

    }
}
