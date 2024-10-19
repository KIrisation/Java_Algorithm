package codetree.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 9 6 1 5 3 7 8 5 3 4 2 5 7 8 7 9 8 7 7 6 4 3 5 7 3 6 8 9 5 7 7 9 8 7 6 2 3 5 6 8 1 2 3 4 5 2 3 5 9 8 7 6 8 3 4 5 6 5 4
 * 6 3 7 9 9
 * <p>
 * 다음과 같이 8 * 8 크기의 행렬이 주어졌을 때, (1, 1)에서 시작하여 오른쪽 혹은 밑으로만 이동하여 (8, 8)로 간다고 했을 때 거쳐간 위치에 적혀있는 숫자의 합 중 가능한 최댓값은 어떻게 될까요?
 **/
public class 격자_안에서_한칸씩_전진하는_DP {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dy = {0, 1}; //우, 아래
    static int[] dx = {1, 0}; //우, 아래

    public static void main(String[] args) {
        int n = 8;
        int[][] problems = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 9, 6, 1, 5, 3, 7, 8, 5},
            {0, 3, 4, 2, 5, 7, 8, 7, 9},
            {0, 8, 7, 7, 6, 4, 3, 5, 7},
            {0, 3, 6, 8, 9, 5, 7, 7, 9},
            {0, 8, 7, 6, 2, 3, 5, 6, 8},
            {0, 1, 2, 3, 4, 5, 2, 3, 5},
            {0, 9, 8, 7, 6, 8, 3, 4, 5},
            {0, 6, 5, 4, 6, 3, 7, 9, 9}
        };

        int[][] dp = new int[n + 1][n + 1];
        dp[1][1] = problems[1][1];
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + problems[i][j], dp[i][j - 1] + problems[i][j]);
            }
        }

        System.out.println(Arrays.deepToString(dp));
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
