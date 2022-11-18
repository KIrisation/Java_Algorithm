package programmers.lv0.day15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 문자열 my_string과 정수 num1, num2가 매개변수로 주어질 때, my_string에서 인덱스 num1과 인덱스 num2에 해당하는 문자를 바꾼 문자열을 return 하도록 solution 함수를
 * 완성해보세요.
 * <p>
 * 제한사항 1 < my_string의 길이 < 100 0 ≤ num1, num2 < my_string의 길이 my_string은 소문자로 이루어져 있습니다. num1 ≠ num2
 * <p>
 * 입출력 예 my_string	num1	num2	result "hello"	1	2	"hlelo" "I love you"	3	6	"I l veoyou"
 */
public class ReplaceIndex {

    public static void main(String[] args) {
        System.out.println(solution("hello",1,2));
    }

    public static String solution(String my_string, int num1, int num2) {
        String answer = "";

        char[] chars = my_string.toCharArray();

        char aNum1 = chars[num1];
        char bNum2 = chars[num2];

        for (int i = 0; i < my_string.length(); i++) {
            if (i == num1) {
                chars[i] = bNum2;
            }

            if (i == num2) {
                chars[i] = aNum1;
            }

            answer += chars[i];
        }

        return answer;
    }

    public static String solution2(String my_string, int num1, int num2) {
        List<String> list = Arrays.stream(my_string.split(""))
                                  .collect(Collectors.toList());

        Collections.swap(list, num1, num2);
        return String.join("", list);
    }
}
