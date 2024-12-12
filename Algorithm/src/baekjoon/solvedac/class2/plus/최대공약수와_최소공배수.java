package baekjoon.solvedac.class2.plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2609
 */
public class 최대공약수와_최소공배수 {

    static int solution1; // 최대공약수
    static int solution2; // 최소공배수
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = reader.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        gcd(N, M);
        solution2 = (N * M) / solution1;

        System.out.println(solution1);
        System.out.println(solution2);
    }

    public static void gcd(int N, int M) {
        if (N == 0) {
            solution1 = M;
        } else {
            gcd(M, N % M);
        }
    }
}
