package baekjoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1436번: 영화감독 숌
 */
public class DirectorShowm {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());

        int num = 666;
        int cnt = 1;
        while (cnt != N) {
            num++;

            if (String.valueOf(num).contains("666")) {
                cnt++;
            }
        }

        System.out.println(num);
    }
}
