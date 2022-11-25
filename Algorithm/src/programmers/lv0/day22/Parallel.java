package programmers.lv0.day22;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 평행 문제 설명 점 네 개의 좌표를 담은 이차원 배열  dots가 다음과 같이 매개변수로 주어집니다.
 * <p>
 * [[x1, y1], [x2, y2], [x3, y3], [x4, y4]] 주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution
 * 함수를 완성해보세요.
 * <p>
 * 제한사항 0 ≤ dots의 원소 ≤ 100 dots의 길이 = 4 dots의 원소의 길이 = 2 dots의 원소는 [x, y] 형태이며 x, y는 정수입니다. 서로 다른 두개 이상의 점이 겹치는 경우는
 * 없습니다. 두 직선이 겹치는 경우(일치하는 경우)에도 1을 return 해주세요. 임의의 두 점을 이은 직선이 x축 또는 y축과 평행한 경우는 주어지지 않습니다. 입출력 예 dots	result [[1, 4],
 * [9, 2], [3, 8], [11, 6]]	1 [[3, 5], [4, 1], [2, 4], [5, 10]]	0
 */
public class Parallel {

    public static void main(String[] args) {

    }

    public int solution(int[][] dots) {
        int answer = 0;
        // 조건이 뭐냐? 평행이다.
        // 평행하려면 어떤 조건이 갖춰지느냐?
        // 점과 점 사이를 잇는다.
        // X 축 증감 값이 같고 Y 축 증감 값이 같다.
        // 가장 먼저 점과 점을 이을 배열의 위치를 선택한다.

        Set<Double> set = new HashSet<>();
        int cnt = 0;

        for (int i = 0; i < dots.length - 1; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                if ((dots[i][0] - dots[i + 1][0]) == 0) {
                    continue;
                }

                cnt++;
                set.add((double) (dots[i][1] - dots[j][1]) / (dots[i][0] - dots[j][0]));
            }
        }

        if (set.size() == cnt) {
            return 0;
        }

        return 1;
    }

    private boolean isMultipleValue(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {

            return true;
        }
        return false;
    }
}
