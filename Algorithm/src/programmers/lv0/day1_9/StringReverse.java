package programmers.lv0.day1_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 문자열 my_string이 매개변수로 주어집니다.
 * my_string을 거꾸로 뒤집은 문자열을 return하도록
 * solution 함수를 완성해주세요.
 */
public class StringReverse {
    public static String solution(String my_string) {
        StringBuilder answer = new StringBuilder();

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            stringList.add(i, String.valueOf(my_string.charAt(i)));
        }

        Collections.reverse(stringList);

        for (int i = 0; i < my_string.length(); i++) {
            answer.append(stringList.get(i));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("hello"));
        System.out.println(solution2("hello"));
    }

    public static String solution2(String my_string) {
        StringBuilder sb = new StringBuilder(my_string);
        sb.reverse();
        return sb.toString();
    }
}
