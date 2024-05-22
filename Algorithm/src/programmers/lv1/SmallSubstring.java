package programmers.lv1;

import java.util.stream.LongStream;

public class SmallSubstring {

    public static void main(String[] args) {
        System.out.println(solution("3141592", "271"));
        System.out.println(solution("500220839878", "7"));
        System.out.println(solution("10203", "15"));
        System.out.println(solution("16", "15"));
        System.out.println(solution("01111111111111", "0"));
    }

    public static int solution(String t, String p) {
        int answer = 0;
        long pValue = Long.parseLong(p);
        for (int i = 0; i < t.length(); i++) {
            if (i + p.length() > t.length()) {
                break;
            }

            long rangeNumber = Long.parseLong(t.substring(i, i + p.length()));

            if (rangeNumber <= pValue) {
                answer++;
            }
        }

        return answer;
    }

    public static int solution2(String t, String p) {
        long targetNumber = Long.parseLong(p);
        int targetNumberLength = p.length();

        return (int) LongStream.range(0L, t.length() - targetNumberLength + 1L)
                               .mapToObj(i -> t.substring((int) i, (int) i + targetNumberLength)).mapToLong(Long::parseLong)
                               .filter(number -> number <= targetNumber)
                               .count();
    }

}
