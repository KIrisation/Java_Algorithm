package programmers.lv2.fail;

import java.util.*;

/**
 * Fail: 이유 시간 초과
 * 구글링 검색 결과 이분 탐색을 이용한 해결 방법 제시
 * 왜 이분 탐색으로 해당 문제를 풀 수 있는지?
 * 해당 풀이가 추가 되어야 함
 */
public class 퍼즐_게임_챌린지_Fail {
    public int solution(int[] diffs, int[] times, long limit) {
        int diffsMax = -1;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] > diffsMax) {
                diffsMax = diffs[i];
            }
        }

        long[] dp = new long[diffsMax + 1]; // level 별로 시간을 담음.

        int level = 1;
        for (int i = level; i < diffsMax; i++) {
            dp[i] = makeDp(i, diffs, times);

        }

        System.out.println(Arrays.toString(dp));

        for (int i = level; i < dp.length; i++) {
            if (dp[i] <= limit) {
                return i;
            }
        }

        System.out.println(Arrays.toString(dp));

        return level;
    }

    public long makeDp(int level, int[] diffs, int[] times) {
        long time = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                time += times[i];
            } else {
                if (i == 0) {
                    time += ((long) times[i]  * (diffs[i] - level));
                    continue;
                }

                time += ((long) (times[i] + times[i - 1])  * (diffs[i] - level))  + times[i];
            }
        }

        return time;
    }

}
