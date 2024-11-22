package programmers.lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178870
 */
public class 연속된_부분_수열의_합 {

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        // 최단 구간 길이 추적 변수
        int minLength = Integer.MAX_VALUE;

        while (right < sequence.length) {
            // 현재 구간의 합이 목표 값과 같을 때
            if (sum == k) {
                int currentLength = right - left;

                // 최단 구간인지 확인 후 갱신
                if (currentLength < minLength) {
                    minLength = currentLength;
                    answer[0] = left;
                    answer[1] = right;
                }

                // left 이동으로 구간 축소
                sum -= sequence[left];
                left++;
            } else if (sum < k) {
                right++;

                if (right < sequence.length) {
                    sum += sequence[right];
                }
            } else { // 구간 합이 목표보다 크면 left를 이동해 축소
                sum -= sequence[left];
                left++;
            }
        }

        return answer;
    }
}