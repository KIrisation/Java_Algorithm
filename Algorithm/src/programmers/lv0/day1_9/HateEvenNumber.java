package programmers.lv0.day1_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HateEvenNumber {
    public static void main(String[] args) {
        solution(10);
        System.out.println(Arrays.toString(solution(10)));
    }

    public static int[] solution(int n) { // 내가 푼 것.
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, i);
        }

        List<Integer> collect = map.keySet()
                                   .stream()
                                   .filter(i -> i % 2 == 1)
                                   .collect(Collectors.toList());

        int[] answer = new int[collect.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = collect.get(i);
        }

        return answer;
    }

    public static int[] solution2(int n) { // 또 다른 사람의 풀이
        return IntStream.rangeClosed(0, n)
                        .filter(value -> value % 2 == 1)
                        .toArray();

    }

    public static int[] solution3(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (n % 2 == 1) {
                list.add(i);
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}



