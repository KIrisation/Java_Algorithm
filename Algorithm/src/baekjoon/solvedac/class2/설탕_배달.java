package baekjoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2839
 */
public class 설탕_배달 {

    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        if (N == 4 || N == 7) {
            System.out.println(-1);
        }
        else if (N % 5 == 0) {
            System.out.println(N / 5);
        }
        else if (N % 5 == 1 || N % 5 == 3) { // 6 8 11 13 16 18 21 23
            System.out.println((N / 5) + 1);
        }
        else if (N % 5 == 2 || N % 5 == 4) { // 9 12 14 17 22 24
            System.out.println((N / 5) + 2);
        }
    }
}
