package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Z {

    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2]);

        recursive(N, y, x);
    }

    public static int recursive(int N, int y, int x) {
        if (N == 0) {
            return result;
        }

        int half = (int) Math.pow(2, N - 1);
        int quadrant;

        if (y >= half && x >= half) {
            quadrant = 3;
            y -= half;
            x -= half;
        } else if (y >= half && x < half) {
            quadrant = 2;
            y -= half;
        } else if (y < half && x >= half) {
            quadrant = 1;
            x -= half;
        } else {
            quadrant = 0;
        }

        int num = (int) Math.pow(4, N - 1);
        result += (num * quadrant);

        return recursive(N - 1, y, x);
    }
}
