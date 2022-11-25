package programmers.lv0.day22;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * 겹치는 선분의 길이 문제 설명 빨간색, 초록색, 파란색 선분이 x축 위에 있습니다. 세 선분의 x좌표 시작과 끝이 [[start, end], [start, end], [start, end]] 형태로 들어있는
 * 2차원 배열 lines가 매개변수로 주어질 때, 두 개 이상의 선분이 겹치는 부분의 길이를return 하도록 solution 함수를 완성해보세요.
 * <p>
 * lines가 [[0, 2], [-3, -1], [-2, 1]]일 때 그림으로 나타내면 다음과 같습니다. 스크린샷 2022-08-08 오후 5.08.46.png
 * <p>
 * 선분이 두 개 이상 겹친 곳은 [-2, -1], [0, 1]로 2만큼 겹쳐있습니다.
 * <p>
 * 제한사항 lines의 길이 = 3 lines의 원소의 길이 = 2 모든 선분은 길이가 1 이상입니다. lines의 원소는 [a, b] 형태이며, a, b는 각각 양 끝점 중 하나입니다. -100 ≤ a < b
 * ≤ 100 입출력 예 lines	result [[0, 1], [2, 5], [3, 9]]	2 [[-1, 1], [1, 3], [3, 9]]	0 [[0, 5], [3, 9], [1, 10]]	8
 */
public class OverlapLines {

    final static int START = 0;
    final static int END = 1;

    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {2, 5}, {3, 9}};
        System.out.println(solution(arr));
    }

    public static int solution(int[][] lines) {
        int result = 0;

        IntSummaryStatistics stats =
                Arrays.stream(lines)
                      .flatMapToInt(Arrays::stream)
                      .summaryStatistics();

        int max = stats.getMax();
        int min = stats.getMin();

        int cnt = 0;
        for (int i = min; i < max; i++) {
            boolean check = false;

            for (int j = 0; j < lines.length; j++) {

                int start = lines[j][0];
                int end = lines[j][1];

                if (i >= start && i + 1 <= end) {
                    if (check) {
                        cnt++;
                        break;
                    }

                    check = true;
                }
            }
        }

        return cnt;
    }
}
