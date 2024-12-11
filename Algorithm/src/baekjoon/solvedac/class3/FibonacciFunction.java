package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1003번: 피보나치 함수
 */
public class FibonacciFunction {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int fibonacciNum;
    static int[][] dp;
    public static void main(String[] args) {
        N = nextInt();

        for (int i = 1; i <= N; i++) {
            fibonacciNum = nextInt();

            dp = new int[fibonacciNum + 2][2]; // 숫자별 0의 갯수, 1의 갯수 저장 용도

            dp[0][0] = 1;
            dp[1][1] = 1;

            for (int j = 2; j <= fibonacciNum; j++) {
                for (int k = 0; k <= 1; k++) {
                    dp[j][k] = dp[j - 1][k] + dp[j - 2][k];
                }
            }

            sb.append(dp[fibonacciNum][0]).append(" ").append(dp[fibonacciNum][1]).append("\n");
        }

        System.out.println(sb);
    }

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
