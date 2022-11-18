package programmers.lv0.day15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 문자열 s가 매개변수로 주어집니다. s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요. 한 번만 등장하는 문자가 없을 경우 빈 문자열을
 * return 합니다.
 * <p>
 * 제한사항 0 < s의 길이 < 1,000 s는 소문자로만 이루어져 있습니다.
 * <p>
 * 입출력 예 s	result "abcabcadc"	"d" "abdc"	"abcd" "hello"	"eho"
 */
public class TextAppearedOnlyOnce {

    public static void main(String[] args) {
        System.out.println(solution("abccabcadc"));
        System.out.println(solution("abdc"));
        System.out.println(solution("hello"));
    }

    public static String solution(String s) {
        String[] split = s.split("");

        for (int i = 0; i < split.length - 1; i++) {
            String findByValue = split[i];

            for (int j = i + 1; j < split.length; j++) {
                if (findByValue.equals(split[j])) {
                    split[i] = "";
                    split[j] = "";
                }
            }
        }

        return Arrays.stream(split)
                     .sorted(Comparator.naturalOrder())
                     .collect(Collectors.joining(""));
    }
}
