package programmers.lv0.day11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.
 */
public class CreateMaximum {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int solution = solution(numbers);
        System.out.println(solution);
    }

    public static int solution(int[] numbers) {
        List<Integer> numbersList = new ArrayList<>();

        for (int number : numbers) {
            Integer integer = number;
            numbersList.add(integer);
        }

        numbersList.sort(Comparator.naturalOrder());

        return numbersList.get(numbersList.size() - 1) * numbersList.get(numbersList.size() - 2);
    }
}
