package baekjoon.solvedac.class2.twoplus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 달팽이는_올라가고싶다 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        int V = Integer.parseInt(s[2]);

        int day = (V - B) / (A - B);

        if ((V - B) % (A - B) != 0) {
            day++;
        }

        System.out.println(day);
    }
}
