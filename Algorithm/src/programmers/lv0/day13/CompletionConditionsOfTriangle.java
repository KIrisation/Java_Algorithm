package programmers.lv0.day13;

import java.util.Arrays;

/**
 * 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
 *
 * 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
 * 삼각형의 세 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다.
 * 세 변으로 삼각형을 만들 수 있다면 1, 만들 수 없다면 2를 return하도록 solution 함수를 완성해주세요.
 */
public class CompletionConditionsOfTriangle {

    public static void main(String[] args) {
        System.out.println(solution2(new int[]{1,2,3}));
        System.out.println(solution2(new int[]{3,6,2}));
        System.out.println(solution2(new int[]{199,72,222}));
    }

    public static int solution(int[] sides) {
        int max = sides[0];
        int sum = 0;
        for (int i = 0; i < sides.length; i++) {
            if (max < sides[i]) {
                max = sides[i];
                continue;
            }
            sum += sides[i];
        }

        if (max < sum) {
            return 1;
        }

        return 2;
    }

    public static int solution2(int[] sides) {
        Arrays.sort(sides);

        if (sides[0] + sides[1] <= sides[2]) {
            return 2;
        }

        return 1;
    }

}
