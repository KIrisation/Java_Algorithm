package programmers.lv0.day20;

import java.util.Arrays;

/**
 * 최댓값 만들기 (2)
 *
 * 문제 설명
 * 정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * -10,000 ≤ numbers의 원소 ≤ 10,000
 * 2 ≤ numbers 의 길이 ≤ 100
 *
 * 입출력 예
 * numbers	result
 * [1, 2, -3, 4, -5]	15
 * [0, -31, 24, 10, 1, 9]	240
 * [10, 20, 30, 5, 5, 20, 5]	600
 */
public class CreateMaximum {

    public static void main(String[] args) {

    }

    public int solution(int[] numbers) {
        int answer = 0;
        int max = 1;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j <= numbers.length - 1; j++) {
                if (max >= numbers[i] * numbers[j]) {
                    continue;
                }
                max = numbers[i] * numbers[j];
            }
        }

        return max;
    }

    public static int solution2(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);

        int num1 = numbers[0] * numbers[1];
        int num2 = numbers[numbers.length - 1]  * numbers[numbers.length - 2];

        if (num1 < num2) {
            return num2;
        } else {
            return num1;
        }
    }

}
