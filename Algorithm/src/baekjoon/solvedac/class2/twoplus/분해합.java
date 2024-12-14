package baekjoon.solvedac.class2.twoplus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2231
 */
public class 분해합 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int seperatorSum = Integer.parseInt(s);

        for (int i = 1; i <= seperatorSum; i++) {
            int sum = i;
            int tmp = i;

            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }

            if (sum == seperatorSum) {
                System.out.println(i);
                break;
            }
        }

    }
}
