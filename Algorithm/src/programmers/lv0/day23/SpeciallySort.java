package programmers.lv0.day23;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 특이한 정렬 문제 설명 정수 n을 기준으로 n과 가까운 수부터 정렬하려고 합니다.
 * 이때 n으로부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다.
 * 정수가 담긴 배열 numlist와 정수 n이 주어질 때
 * numlist의 원소를 n으로부터 가까운 순서대로 정렬한 배열을 return하도록 solution 함수를 완성해주세요.
 * <p>
 * 제한사항 1 ≤ n ≤ 10,000 1 ≤ numlist의 원소 ≤ 10,000 1 ≤ numlist의 길이 ≤ 100 numlist는 중복된 원소를 갖지 않습니다.
 * <p>
 * 입출력 예 numlist	n	result [1, 2, 3, 4, 5, 6]	4	[4, 5, 3, 6, 2, 1] [10000,20,36,47,40,6,10,7000]	30	[36, 40, 20, 47, 10,
 * 6, 7000, 10000]
 */
public class SpeciallySort {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6}, 4));
    }

    public static int[] solution(int[] numlist, int n) {
        List<Integer> numList = Arrays.stream(numlist)
                                      .boxed()
                                      .collect(Collectors.toList());

        for (int i = 0; i < numList.size() - 1; i++) {
            int upForInt = numList.get(i);
            for (int j = i + 1; j < numList.size(); j++) {
                int downForInt = numList.get(j);

                if (Math.abs(numList.get(i) - n) < Math.abs(numList.get(j) - n)) {
                    break;
                }

                if (Math.abs(numList.get(i) - n) > Math.abs(numList.get(j) - n)) {
                    numList.set(i, downForInt);
                    numList.set(j, upForInt);
                    i = -1;
                    break;
                }

                if (Math.abs(numList.get(i) - n) == Math.abs(numList.get(j) - n)) {
                    if (numList.get(i) > numList.get(j)) {
                        break;
                    }

                    numList.set(i, downForInt);
                    numList.set(j, upForInt);
                    i = -1;
                    break;
                }
            }

        }

        return numList.stream()
                      .mapToInt(i -> i)
                      .toArray();
    }
}