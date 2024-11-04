package codetree.dp;

import java.util.Arrays;

/**
 * 가치가 1, 4, 5, 9인 4개의 동전이 주어졌을 때, 금액 21을 거슬러 주기 위해 필요한 최소 동전의 수를 구해보려고 합니다.
 * <p>
 * 이 문제를 해결하기 위해 dp[i]를 지금까지 선택한 동전의 합이 i라 했을 때, 필요한 최소 동전 횟수라고 정의하여 dp table을 완성시켜보려고 합니다.
 * <p>
 * 다음 빈칸에 들어갈 숫자를 순서대로 골라보세요.
 */
public class 은행 {
    static int[] coins = {1, 4, 5, 9};

    public static void main(String[] args) {
        int[] dp = new int[22]; // 금액 21을 맞추기 위한 배열
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                int prev = i - coin; // i - coins[j] 원 => coins[j]원을 더하여 현재 금액을 만들기 전

                if (prev < 0 || dp[prev] == Integer.MAX_VALUE) {
                    continue;
                }

                dp[i] = Math.min(dp[i], dp[prev] + 1);
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(i + ": " + dp[i]);
        }
    } // 11: 3 | 16: 4 | 17: 3 | 21: 4
}
