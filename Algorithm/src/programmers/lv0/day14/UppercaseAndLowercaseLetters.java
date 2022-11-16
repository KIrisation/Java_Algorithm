package programmers.lv0.day14;

import java.util.stream.Collectors;

/**
 * 문자열 my_string이 매개변수로 주어질 때, 대문자는 소문자로 소문자는 대문자로 변환한 문자열을 return하도록 solution 함수를 완성해주세요
 */
public class UppercaseAndLowercaseLetters {

    public static void main(String[] args) {
        System.out.println(solution("aaaCCC"));
    }

    public static String solution(String my_string) {
        String answer = "";

        String[] split = my_string.split("");
        char[] chars = my_string.toCharArray();

        for (int i = 0; i < my_string.length(); i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                answer += split[i].toLowerCase();
                continue;
            }
            answer += split[i].toUpperCase();
        }

        return answer;
    }

    public static String solution2(String my_string) {
        return my_string.chars()
                        .mapToObj(operand -> String.valueOf((char)
                                (Character.isLowerCase(operand) ?
                                        Character.toUpperCase(operand) : Character.toLowerCase(operand))))
                        .collect(Collectors.joining());
    }

}
