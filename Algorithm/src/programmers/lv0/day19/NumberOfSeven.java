package programmers.lv0.day19;

import java.util.Arrays;

/**
 * 7의 개수
 * 문제 설명
 * 머쓱이는 행운의 숫자 7을 가장 좋아합니다. 정수 배열 array가 매개변수로 주어질 때, 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성해보세요.
 *
 * 제한사항
 * 1 ≤ array의 길이 ≤ 100
 * 0 ≤ array의 원소 ≤ 100,000
 *
 * 입출력 예
 * array	result
 * [7, 77, 17]	4
 * [10, 29]	0
 */
public class NumberOfSeven {

    public static void main(String[] args) {

    }

    public int solution(int[] array) {
        int answer = 0;
        StringBuilder arrayToString = new StringBuilder();

        for (int i : array) {
            arrayToString.append(i);
        }

        String[] split = arrayToString.toString().split("");
        int cnt = 0;
        for (String s : split) {
            if (s.equals("7")) {
                cnt++;
            }
        }
        return cnt;
    }

}
