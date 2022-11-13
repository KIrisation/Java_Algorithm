package programmers.lv0.day12;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Factorization {

    public static void main(String[] args) {
        int[] solution = solution(120);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution(120)[i]);
        }
    }

    public static int[] solution(int n) {
        Set<Integer> integers = new HashSet<>();
        int i = 2;
        while (true) {
            if (n % i == 0) {
                n /= i;
                integers.add(i);
                continue;
            }

            if (n / i == 0) {
                break;
            }

            i++;
        }

        return integers.stream()
                       .sorted(Comparator.naturalOrder())
                       .mapToInt(value -> value)
                       .toArray();
    }
}
