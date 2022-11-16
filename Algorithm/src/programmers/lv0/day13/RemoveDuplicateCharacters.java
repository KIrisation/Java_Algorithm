package programmers.lv0.day13;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 문자열 my_string이 매개변수로 주어집니다. my_string에서 중복된 문자를 제거하고 하나의 문자만 남긴 문자열을 return하도록 solution 함수를 완성해주세요.
 */
public class RemoveDuplicateCharacters {

    public static void main(String[] args) {
        System.out.println(solution("Hello My Name is Name"));
    }

    public static String solution(String my_string) {
        String result = "";
        String[] split = my_string.split("");

        for (int i = 0; i < my_string.length() - 1; i++) {
            String cursor = split[i];
            for (int j = i + 1; j < my_string.length(); j++) {
                if (cursor.equals(split[j])) {
                    split[j] = "";
                }
            }
        }

        for (String s : split) {
            result += s;
        }

        return result;
    }

    /**
     * https://crazykim2.tistory.com/582 - LinkedHashSet 참조
     *
     * @param my_string
     * @return
     */
    public String solution1(String my_string) {
        String[] result = my_string.split("");
        Set<String> set = new LinkedHashSet<>(List.of(result));

        return String.join("", set);
    }

    public String solution2(String my_string) {
        return my_string.chars()
                        .mapToObj(Character::toString)
                        .distinct()
                        .collect(Collectors.joining());
    }

}
