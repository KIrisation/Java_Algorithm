package programmers.lv0.day17;

import java.util.Arrays;

/**
 * 정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요
 *
 * 제한사항
 * 0 ≤ n ≤ 1,000,000
 *
 * 입출력 예
 * n	result
 * 1234	10
 * 930211	16
 */
public class AddDigits {

    public static int solution(int n) {
        String s = String.valueOf(n);
        String[] split = s.split("");
        Arrays.stream(split).mapToInt(Integer::parseInt).sum();
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {

    }
}
