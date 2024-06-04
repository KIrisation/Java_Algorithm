package programmers.lv2.test;

import java.util.ArrayList;
import java.util.List;

/**
 *  문제: 문자열 압축 - Level 2
 *  문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/60057
 *  문제 풀이: https://github.com/Irisation23/Java_Algorithm/issues/96
 */
public class Problem08 {

    public static void main(String[] args) {
        Problem08Solution problem08Solution = new Problem08Solution();
        System.out.println(problem08Solution.solution2("aab"));

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("");

        System.out.println(stringBuilder);

//        System.out.println("hello".substring(0, 1));
    }
}

class Problem08Solution {
    public int solution2(String s) {
        int min = Integer.MAX_VALUE;

        for (int length = 1; length <= s.length(); length++) {
            int compressed = compress(s, length);
            if (compressed < min) {
                min = compressed;
            }
        }

        return min;
    }

    private int compress(String source, int length) {
        StringBuilder builder = new StringBuilder();
        String last = "";
        int count = 0;

        // aab
        for (String token : split(source, length)) {
            if (token.equals(last)) {
                count++;
            } else {
                if (count > 1) {
                    builder.append(count);
                }

                builder.append(last); // 빈 문자일 경우 빈 문자열이 append 되지는 않음.
                last = token;
                count = 1;
            }
        }

        if (count > 1) {
            builder.append(count);
        }

        builder.append(last);

        System.out.println(builder);
        return builder.length();
    }

    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();

        for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
            int endIndex = startIndex + length;

            if (endIndex > source.length()) {
                endIndex = source.length();
            }

            tokens.add(source.substring(startIndex, endIndex));
        }

        return tokens;
    }
}
