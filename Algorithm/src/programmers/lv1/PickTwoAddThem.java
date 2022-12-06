package programmers.lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 두 개 뽑아서 더하기
 * 문제 설명
 * 정수 배열 numbers가 주어집니다.
 * numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers의 길이는 2 이상 100 이하입니다.
 * numbers의 모든 수는 0 이상 100 이하입니다.
 * 입출력 예
 * numbers	result
 * [2,1,3,4,1]	[2,3,4,5,6,7]
 * [5,0,2,7]	[2,5,7,9,12]
 *
 * 생각해야 할 점.
 * 1. 더한 수가 같으면 중복을 제거해야한다. may be - Set
 * 2. 모든 수 배열을 오름차순으로 정렬해야한다. may be - sort()
 */
public class PickTwoAddThem {
    public static int[] solution(int[] numbers) {
        Set<Integer> twoNumbersSum = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                twoNumbersSum.add(numbers[i] + numbers[j]);
            }
        }

        return twoNumbersSum.stream()
                            .sorted(Comparator.naturalOrder())
                            .mapToInt(i -> i)
                            .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1})));
    }
}
