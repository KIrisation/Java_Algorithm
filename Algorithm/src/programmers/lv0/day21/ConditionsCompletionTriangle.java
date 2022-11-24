package programmers.lv0.day21;

import java.util.Arrays;

/**
 * 삼각형의 완성조건 (2)
 *
 * 문제 설명
 * 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
 *
 * 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
 * 삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다. 나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * sides의 원소는 자연수입니다.
 * sides의 길이는 2입니다.
 * 1 ≤ sides의 원소 ≤ 1,000
 *
 * 입출력 예
 * sides	result
 * [1, 2]	1
 * [3, 6]	5
 * [11, 7]	13
 */
public class ConditionsCompletionTriangle {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2}));
    }

    public static int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);

        int sum = Arrays.stream(sides).sum();

        int cnt = 0;

        int sides1 = sides[0];
        int sides2 = sides[1];

        for (int i = 1; i <= sides2; i++) {
            if (i + sides1 > sides2) {
                cnt++;
            }
        }

        for (int i = sides2; i < sum; i++) {
            if (sides1 + i > sum) {
                cnt++;
            }
        }

        return cnt;
    }
}
