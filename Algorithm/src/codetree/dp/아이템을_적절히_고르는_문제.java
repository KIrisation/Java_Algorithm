package codetree.dp;

import java.util.Arrays;

// 배낭 채우기
public class 아이템을_적절히_고르는_문제 {

    public static void main(String[] args) {
        int bagSize = 8;
//        int[] W = {0, 2, 6, 2, 3, 4};
//        int[] P = {0, 3, 5, 4, 2, 3};
        int[] W = {0, 3, 1, 4, 5, 2};
        int[] P = {0, 4, 1, 2, 6, 3};

        int[][] dp = new int[W.length][bagSize + 1];


        dp[0][1] = -1;
        dp[0][2] = -1;
        dp[0][3] = -1;
        dp[0][4] = -1;
        dp[0][5] = -1;
        dp[0][6] = -1;
        dp[0][7] = -1;
        dp[0][8] = -1;
        dp[1][3] = 4;

        for (int i = 2; i < W.length; i++) { // 보석 갯수
            for (int j = 1; j <= bagSize; j++) { // 가방 크기
                // 물건을 담을 수 없는 경우
                if (j < W[i]) {
                    dp[i][j] = dp[i - 1][j];
                }

                // 물건을 담을 수 있는 경우
                if (j >= W[i]) {
                    if (dp[i - 1][j] == -1) {
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + P[i]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.println("dp["+ i +"][" + j + "]" + ":" + dp[i][j]);
            }
        }
    }
}
