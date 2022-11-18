package programmers.lv0.day15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 정수 n이 매개변수로 주어질 때, n의 약수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.
 */
public class Factors {

    public static int[] solution(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);

                if (i * i != n) {
                    list.add(n / i);
                }
            }
        }

        return list.stream()
                    .sorted(Comparator.naturalOrder())
                   .mapToInt(i -> i)
                   .toArray();
    }

    public static void main(String[] args) {
        for (int i : solution(24)) {
            System.out.println(i);
        }
    }

}
