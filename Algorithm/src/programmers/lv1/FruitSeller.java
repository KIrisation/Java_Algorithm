package programmers.lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FruitSeller {

    public static void main(String[] args) {
        System.out.println(solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
    }

    public static int solution(int k/* 사과의 최대 점수 */, int m/* 한 상자에 담긴 사과 개수 */, int[] score) {
        //최대 이익을 리턴
        int answer = 0;
        List<Integer> list = Arrays.stream(score)
                                   .boxed()
                                   .sorted(Comparator.reverseOrder())
                                   .collect(Collectors.toList());

        for (int i = m - 1; i < list.size(); i += m) {
            answer += list.get(i) * m;
        }

        return answer;

//        int index = 0;
//        while (true) {
//            if (index >= list.size() || index + m > list.size()) {
//                break;
//            }
//
//            answer += list.get(index + m - 1) * m;
//            index += m;
//        }
//
//        return answer;
    }
}
