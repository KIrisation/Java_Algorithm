package programmers.lv0.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 정수 배열 array가 매개변수로 주어질 때, 가장 큰 수와 그 수의 인덱스를 담은 배열을 return 하도록 solution 함수를 완성해보세요.
 * <p>
 * 제한사항 1 ≤ array의 길이 ≤ 100 0 ≤ array 원소 ≤ 1,000 array에 중복된 숫자는 없습니다.
 * <p>
 * 입출력 예 array	result [1, 8, 3]	[8, 1] [9, 10, 11, 8]	[11, 2]
 */
public class FindLargestNumber {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 8, 3}).get(0));
        System.out.println(solution(new int[]{1, 8, 3}).get(1));
    }

    public static List<Integer> solution(int[] array) {
        Integer max = Arrays.stream(array)
                            .max()
                            .orElse(0);

        List<Integer> list = new ArrayList<>();

        int idx = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) {
                idx = i;
            }
        }

        list.add(max);
        list.add(idx);

        return list;
    }

}
