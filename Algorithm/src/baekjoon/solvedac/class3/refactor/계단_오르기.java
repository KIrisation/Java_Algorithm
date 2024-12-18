package baekjoon.solvedac.class3.refactor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 계단_오르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        int[] stairs = new int[N];
        for (int i = 0; i < N; i++) {
            stairs[i] = Integer.parseInt(reader.readLine());
        }

        // N이 1이나 2인 경우 별도 처리
        if (N == 1) {
            writer.write(String.valueOf(stairs[0]));
            writer.flush();
            return;
        }

        if (N == 2) {
            writer.write(String.valueOf(stairs[0] + stairs[1]));
            writer.flush();
            return;
        }

        // dp[i][1]: i번째 계단을 밟을 때 1칸 연속으로 밟은 경우의 최대 점수
        // dp[i][2]: i번째 계단을 밟을 때 2칸 연속으로 밟은 경우의 최대 점수
        int[][] dp = new int[N][3];

        dp[0][1] = stairs[0];
        dp[0][2] = 0; // 첫 계단을 연속 2칸씩 밟아서 도달할 수 없음
        dp[1][1] = stairs[1];
        dp[1][2] = stairs[0] + stairs[1];

        for (int i = 2; i < N; i++) {
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + stairs[i];
            dp[i][2] = dp[i-1][1] + stairs[i];
        }

        int result = Math.max(dp[N-1][1], dp[N-1][2]);
        writer.write(String.valueOf(result));
        writer.flush();

    }
}
