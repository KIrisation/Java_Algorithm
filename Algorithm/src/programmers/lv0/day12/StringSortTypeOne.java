package programmers.lv0.day12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 문자열 my_string이 매개변수로 주어질 때, my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return 하도록 solution 함수를 작성해보세요.
 */
public class StringSortTypeOne {

    public static void main(String[] args) {
        for (int p2o4i8gj2 : solution("p2o4i8gj2")) {
            System.out.println(p2o4i8gj2);
        }


    }

    public static int[] solution(String my_string) {
        List<Integer> answer = new ArrayList<>();

        String[] split = my_string.split("");
        for (int i = 0; i < split.length; i++) {
            if (my_string.charAt(i) >= 'a' && my_string.charAt(i) <= 'z') {
                split[i] = "";
            }
        }

        for (String s : split) {
            if (s.equals("")) {
                continue;
            }
            answer.add(Integer.parseInt(s));
        }

        return answer.stream()
                     .sorted(Comparator.naturalOrder())
                     .mapToInt(i -> i)
                     .toArray();
    }
}
