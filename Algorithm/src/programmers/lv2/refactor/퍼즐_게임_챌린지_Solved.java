package programmers.lv2.refactor;

/**
 *  기존 코드와 다른 점은
 *  기존 코드에서는 dp 배열에 모든 레벨의 값을 담으려고 했었기 때문에 시간초과가 났다.
 *
 *  해당 코드에서 개선한 점은 모든 레벨 값을 찾는 방법 말고, 이분탐색을 통해 기존의 N이 걸렸던 시간 복잡도를 logN의 시간복잡도로 개선했다.
 */
public class 퍼즐_게임_챌린지_Solved {

    int solution(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = limit;

        while (left < right) {
            long mid = (left + right) >> 1;

            if (!isPossible(diffs, times, mid, limit)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int) left;
    }

    private boolean isPossible(int[] diffs, int[] times, long level, long limit) {
        long tmp = (long) times[0];

        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] > level) {
                tmp += (diffs[i] - level) * (times[i - 1] + times[i]);
            }

            tmp += times[i];
        }

        return limit < tmp;
    }
}
