package codetree.dp;

import java.util.Arrays;

/**
 * 숫자를 쪼개서 암호처럼 사용하려고 합니다.
 * 암호를 만드는 과정은 다음과 같습니다.
 * 1. 숫자를 1, 2, 3, 4의 합으로 바꿉니다.
 * 2. 숫자의 합에서 사용된 숫자를 일렬로 나열합니다.
 * 예를 들어, 4를 활용하면
 * 1 + 1 + 1 + 1 → 1111
 * 1 + 1 + 2 → 112
 * 1 + 2 + 1 → 121
 * 2 + 1 + 1 → 211
 * 1 + 3 → 13
 * 2 + 2 → 22
 * 3 + 1 → 31
 * 4 → 4
 * 와 같이 8개의 암호를 만들 수 있습니다.
 * 이런 방식으로 암호를 만든다고 가정하면, 8로는 몇 개의 암호를 만들 수 있을까요?
 */
public class 숫자_암호_만들기 {

    public static void main(String[] args) {
        int[] dp = new int[9];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= 4; j++) {
                if (i >= j) {
                    dp[i] += dp[i - j];
                }
            }
        }

        System.out.println(Arrays.toString(dp));
    }
}
