package baekjoon.solvedac.class3.fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 해당 문제는 DFS로 문제를 풀 경우
 * 같은 연산을 여러번 할 수 있는 문제가 발생하기 때문에
 * DP로 풀어야한다.
 */
public class 계단_오르기_시간초과 {

    public static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());

        int[] stairs = new int[N];
        for (int i = 0; i < N; i++) {
            stairs[i] = Integer.parseInt(reader.readLine());
        }

        dfs(stairs, 1, stairs[0], 1);

        writer.write(String.valueOf(maxSum));
        writer.flush();
    }

    public static void dfs(int[] stairs, int idx, int sum, int cnt) {
        if (idx > stairs.length) {
            return;
        }

        if (idx == stairs.length) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        if (cnt == 3) {
            return;
        }

        dfs(stairs, idx + 1, sum + stairs[idx], cnt + 1);
        dfs(stairs, idx + 2, sum + stairs[idx], 1);
    }
}
