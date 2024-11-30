package programmers.lv2;

import java.util.Arrays;

public class 시소_짝꿍_이분탐색 {

    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        int prev = 0;
        for (int i = 0; i < weights.length - 1; i++) {
            if (i > 0 && weights[i] == weights[i-1]) {
                prev--;
                answer += prev;
                continue;
            }

            int j = findRight(weights, weights[i], i + 1);
            prev = 0;
            for (; j > 1; j--) {
                if (weights[i] ==  weights[j] ||
                    weights[i] * 2 == weights[j] ||
                    weights[i] * 3 == weights[j] * 2 ||
                    weights[i] * 4 == weights[j] * 3) {
                    prev++;
                }
            }
            answer += prev;
        }

        return answer;
    }

    public int findRight(int[] weights, int num, int i) {
        int left = i;
        int right = weights.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (weights[mid] > num * 2) {
                return mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
