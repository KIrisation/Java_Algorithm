package programmers.lv0.day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 문자열 정렬하기 (2)
 *
 * 문제 설명
 * 영어 대소문자로 이루어진 문자열 my_string이 매개변수로 주어질 때,
 * my_string을 모두 소문자로 바꾸고 알파벳 순서대로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.
 *
 * 제한사항
 * 0 < my_string 길이 < 100
 *
 * 입출력 예
 * my_string	result
 * "Bcad"	"abcd"
 * "heLLo"	"ehllo"
 * "Python"	"hnopty"
 */
public class SortStrings {

    public static void main(String[] args) {
        System.out.println(solution("Bcad"));
        System.out.println(solution("heLLo"));
        System.out.println(solution("Python"));
    }

    public static String solution(String my_string) {
        String answer = "";
        char[] stringToChar = my_string.toCharArray();
        List<Character> charList = new ArrayList<>();
        for (char c : stringToChar) {
            charList.add(Character.toLowerCase(c));
        }

        charList.sort(Comparator.naturalOrder());
        return charList.stream()
                       .map(String::valueOf)
                       .collect(Collectors.joining());
    }

    public static String solution2(String my_string) {
        char[] c = my_string.toLowerCase()
                            .toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

}
