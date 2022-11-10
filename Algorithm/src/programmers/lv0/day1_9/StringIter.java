package programmers.lv0.day1_9;

/**
 * 문자열 my_string과 정수 n이 매개변수로 주어질 때,
 * my_string에 들어있는 각 문자를 n만큼 반복한 문자열을 return 하도록
 * solution 함수를 완성해보세요.
 */
public class StringIter {
    public static String solution(String my_string, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            stringBuilder.append(String.valueOf(my_string.charAt(i)).repeat(n));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        solution("hello", 3);
    }
}
