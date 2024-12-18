package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * https://www.acmicpc.net/problem/9095
 */
public class 더하기123 {

    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;

        for (int i = 5; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]+ dp[i - 3];
        }

        for (int i = 0; i < N; i++) {
            int answer = Integer.parseInt(reader.readLine());
            System.out.println(dp[answer]);
        }
    }
}
