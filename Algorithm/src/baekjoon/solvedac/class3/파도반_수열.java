package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 왜 dp는 int가 아니고 long일까?
 * int 범위를 벗어나는 결과 값이 존재함.
 */
public class 파도반_수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 5;

        for (int i = 9; i <= 100; i++) {
            dp[i] = dp[i - 5] + dp[i - 1];
        }

        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            writer.write(String.valueOf(dp[Integer.parseInt(reader.readLine())]));
            writer.newLine();
        }

        writer.flush();
    }
}
